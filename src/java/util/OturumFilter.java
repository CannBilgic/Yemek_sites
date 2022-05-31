/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import entity.Kullanicilar;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mfurk
 */
@WebFilter("/*")
public class OturumFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        Kullanicilar kullanici = (Kullanicilar) req.getSession().getAttribute("validUser");

        if (kullanici == null) {
            if (url.contains("admin")) {
                res.sendRedirect(req.getContextPath() + "/panel/Oturum.xhtml");
            } else {
                fc.doFilter(request, response);
            }
        } else {
            if (url.contains("login")) {
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            } else {
                fc.doFilter(request, response);
            }
        }
    }
   
}
