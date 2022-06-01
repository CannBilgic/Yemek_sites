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
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
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

    private Kullanicilar entity;
    private KullanicilarDAO dao;
    private List<Kullanicilar> list;
    
    public String getTitle(int id){
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
        this.list = this.getDao().getList();
        return list;
    }

    /**
     * Creates a new instance of KullanicilarBean
     */
    public void setList(List<Kullanicilar> list) {
        this.list = list;
    }
    public void create(){
        this.getDao().create(entity);
        entity = new Kullanicilar();
    }
    public void delete(Kullanicilar k){
        this.getDao().delete(k);
        entity = new Kullanicilar();
    }
    public void clear(){
        entity = new Kullanicilar();
    }
    public void update(){
       this.getDao().update(entity);
        entity = new Kullanicilar(); 
    }
    
    
    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException{
        String v = (String) value;
        if(v.isEmpty()){
            throw new ValidatorException(new FacesMessage("Şifre alanı boş bırakılamaz"));
        }else if( v.length() < 6){
            throw new ValidatorException(new FacesMessage("Şifre 6 haneden kısa olamaz"));
        }
        
        return true;
    }
    
    public void login(){
        if(this.getDao().login(entity) == 1){
            entity = new Kullanicilar();
            Map<String, Object> eklenen = new HashMap<String, Object>()
            {
                {
                    put("validUser", entity);
                    put("isAdmin", true);
                }
            };
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().putAll(eklenen);
        }else if(this.getDao().login(entity) == 2){
            entity = new Kullanicilar();
            Map<String, Object> eklenen = new HashMap<String, Object>()
            {
                {
                    put("validUser", entity);
                    put("isAdmin", false);
                }
            };
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().putAll(eklenen);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre yanlış"));
        }
    }
    public KullanicilarBean() {

    }

}
