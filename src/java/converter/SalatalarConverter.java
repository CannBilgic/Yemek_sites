/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SalatalarDAO;
import entity.Salatalar;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Samet
 */
@FacesConverter("salatalarConverter")
public class SalatalarConverter implements Converter{
   
    private SalatalarDAO salatalarDAO;

    public SalatalarDAO getSalatalarDAO() {
        if(salatalarDAO== null){
            this.salatalarDAO= new SalatalarDAO();
            
        }
        return salatalarDAO;
    }

    public void setSalatalarDAO(SalatalarDAO salatalarDAO) {
        this.salatalarDAO = salatalarDAO; 
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id =Integer.valueOf(string);
        Salatalar s = this.getSalatalarDAO().findByID(id);
        return s;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Salatalar k =(Salatalar) t;
        return String.valueOf(k.getId());
    }
    
}
