/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AnaYemekDAO;
import entity.AnaYemek;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

/**
 *
 * @author mfurk
 */
@Named(value = "anaYemekBean")
@SessionScoped
public class AnaYemekBean implements Serializable {
    private AnaYemek entity;
    private AnaYemekDAO dao;
    private List<AnaYemek> list;
    
    public AnaYemek getEntity(){
        if (entity == null) {
            entity = new AnaYemek();
        }
        return entity;
    }
    
    public void setEntity(AnaYemek entity) {
        this.entity = entity;
    }
    
    public AnaYemekDAO getDao() {
        if (dao == null) {
            dao = new AnaYemekDAO();
        }
        return dao;
    }
    
    public void setDao(AnaYemekDAO dao) {
        this.dao = dao;
    }
    
    public List<AnaYemek> getList() {
        this.list = this.getDao().getList();
        return list;
    }
    
    public void setList(List<AnaYemek> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        entity = new AnaYemek();
    }
    public void delete(AnaYemek k){
        this.getDao().delete(k);
        entity = new AnaYemek();
    }
    public void clear(){
        entity = new AnaYemek();
    }
    public void update(){
       this.getDao().update(entity);
        entity = new AnaYemek(); 
    }

    public AnaYemekBean() {

    }
}
