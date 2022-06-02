/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullanicilarDAO;
import entity.Kullanicilar;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author can
 */
@Named
@SessionScoped
public class KullanicilarBean implements Serializable {

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {

            this.page = this.getPageCount();

        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    private Kullanicilar entity;
    private KullanicilarDAO dao;
    private List<Kullanicilar> list;

    public String getTitle(int id) {
        Kullanicilar k = this.getDao().findByID(id);
        return k.getKullanici_adi();
    }

    public Kullanicilar getEntity() {
        if (entity == null) {
            entity = new Kullanicilar();
        }
        return entity;
    }

    public void setEntity(Kullanicilar entity) {

        this.entity = entity;
    }

    public KullanicilarDAO getDao() {
        if (dao == null) {
            dao = new KullanicilarDAO();
        }
        return dao;
    }

    public void setDao(KullanicilarDAO dao) {
        this.dao = dao;
    }

    public List<Kullanicilar> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    /**
     * Creates a new instance of KullanicilarBean
     */
    public void setList(List<Kullanicilar> list) {
        this.list = list;
    }

    public void create() throws IOException {
        this.getDao().create(entity);
        entity = new Kullanicilar();
        ExternalContext ec = FacesContext.getCurrentInstance()
                .getExternalContext();
        ec.redirect(ec.getRequestContextPath()
                + "/panel/Oturum.xhtml");
    }

    public void delete(Kullanicilar k) {
        this.getDao().delete(k);
        entity = new Kullanicilar();
    }

    public void clear() {
        entity = new Kullanicilar();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kullanicilar();
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre alanı boş bırakılamaz"));
        } else if (v.length() < 6) {
            throw new ValidatorException(new FacesMessage("Şifre 6 haneden kısa olamaz"));
        }

        return true;
    }

    public void login() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance()
                .getExternalContext();

        if (this.getDao().login(entity) == 1) {
            entity = new Kullanicilar();
            Map<String, Object> eklenen = new HashMap<String, Object>() {
                {
                    put("validUser", entity);
                    put("isAdmin", true);
                }
            };

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().putAll(eklenen);
            ec.redirect(ec.getRequestContextPath()
                    + "/index.xhtml");
        } else if (this.getDao().login(entity) == 2) {
            entity = new Kullanicilar();
            Map<String, Object> eklenen = new HashMap<String, Object>() {
                {
                    put("validUser", entity);
                    put("isAdmin", false);
                }
            };

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().putAll(eklenen);
            ec.redirect(ec.getRequestContextPath()
                    + "/index.xhtml");

        } else {
            FacesContext.getCurrentInstance().addMessage("form:password", new FacesMessage("Kullanıcı adı veya şifre yanlış"));
        }
    }

    public KullanicilarBean() {

    }

}
