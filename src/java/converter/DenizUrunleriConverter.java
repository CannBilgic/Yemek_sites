/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.DenizUrunleriDAO;
import entity.DenizUrunleri;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Samet
 */
@FacesConverter("denizUrunleriConverter")
public class DenizUrunleriConverter implements Converter{
   
    private DenizUrunleriDAO denizurunleriDAO;

    public DenizUrunleriDAO getDenizUrunleriDAO() {
        if(denizurunleriDAO== null){
            this.denizurunleriDAO= new DenizUrunleriDAO();
            
        }
        return denizurunleriDAO;
    }

    public void setSalatalarDAO(DenizUrunleriDAO denizurunleriDAO) {
        this.denizurunleriDAO = denizurunleriDAO; 
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id =Integer.valueOf(string);
        DenizUrunleri d = this.getDenizUrunleriDAO().findByID(id);
        return d;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        DenizUrunleri k =(DenizUrunleri) t;
        return String.valueOf(k.getId());
    }
    
}
