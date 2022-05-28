/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.IceceklerDAO;
import entity.Icecekler;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

/**
 *
 * @author mfurk
 */
@Named(value = "iceceklerBean")
@SessionScoped
public class IceceklerBean implements Serializable{
    private Icecekler entity;
    private IceceklerDAO dao;
    private List<Icecekler> list;
    
    public Icecekler getEntity(){
        if (entity == null) {
            entity = new Icecekler();
        }
        return entity;
    }
    
    public void setEntity(Icecekler entity) {
        this.entity = entity;
    }
    
    public IceceklerDAO getDao() {
        if (dao == null) {
            dao = new IceceklerDAO();
        }
        return dao;
    }
    
    public void setDao(IceceklerDAO dao) {
        this.dao = dao;
    }
    
    public List<Icecekler> getList() {
        this.list = this.getDao().getList();
        return list;
    }
    
    public void setList(List<Icecekler> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        entity = new Icecekler();
    }
    public void delete(Icecekler k){
        this.getDao().delete(k);
        entity = new Icecekler();
    }
    public void clear(){
        entity = new Icecekler();
    }
    public void update(){
       this.getDao().update(entity);
        entity = new Icecekler(); 
    }

    public IceceklerBean() {

    }
}
