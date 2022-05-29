/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KullanicilarDAO;
import entity.Kullanicilar;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author bilgi
 */
@FacesConverter("kullanicilarConverter")
public class KullanicilarConverter implements Converter {
    private KullanicilarDAO kullanicilarDAO;

    public KullanicilarDAO getKullanicilarDAO() {
        if(kullanicilarDAO== null){
            this.kullanicilarDAO= new KullanicilarDAO();
            
        }
        return kullanicilarDAO;
    }

    public void setKullanicilarDAO(KullanicilarDAO kullanicilarDAO) {
        this.kullanicilarDAO = kullanicilarDAO; 
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id =Integer.valueOf(string);
        Kullanicilar k = this.getKullanicilarDAO().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kullanicilar k =(Kullanicilar) t;
        return String.valueOf(k.getId());
    }
    
}
