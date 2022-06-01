/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.IceceklerDAO;
import entity.Icecekler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author mfurk
 */
@FacesConverter("iceceklerConverter")
public class IceceklerConverter implements Converter{
   
    private IceceklerDAO iceceklerDAO;

    public IceceklerDAO getIceceklerDAO() {
        if(iceceklerDAO== null){
            this.iceceklerDAO= new IceceklerDAO();
            
        }
        return iceceklerDAO;
    }

    public void setIceceklerDAO(IceceklerDAO iceceklerDAO) {
        this.iceceklerDAO = iceceklerDAO; 
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id =Integer.valueOf(string);
        Icecekler i = this.getIceceklerDAO().findByID(id);
        return i;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Icecekler k =(Icecekler) t;
        return String.valueOf(k.getId());
    }
    
}
