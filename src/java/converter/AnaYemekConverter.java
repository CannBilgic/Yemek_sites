/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.AnaYemekDAO;
import entity.AnaYemek;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author mfurk
 */
@FacesConverter("anaYemekConverter")
public class AnaYemekConverter implements Converter {
    private AnaYemekDAO anayemekDAO;

    public AnaYemekDAO getAnaYemekDAO() {
        if(anayemekDAO== null){
            this.anayemekDAO= new AnaYemekDAO();
            
        }
        return anayemekDAO;
    }

    public void setAnaYemekDAO(AnaYemekDAO anayemekDAO) {
        this.anayemekDAO = anayemekDAO; 
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id =Integer.valueOf(string);
        AnaYemek k = this.getAnaYemekDAO().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        AnaYemek k =(AnaYemek) t;
        return String.valueOf(k.getId());
    }
    
}
