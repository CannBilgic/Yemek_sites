/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.YetkililerDAO;
import entity.Yetkililer;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

/**
 *
 * @author mfurk
 */
@Named(value = "yetkililerBean")
@SessionScoped
public class YetkililerBean implements Serializable {
    private Yetkililer entity;
    private YetkililerDAO dao;
    private List<Yetkililer> list;
    
    public Yetkililer getEntity(){
        if (entity == null) {
            entity = new Yetkililer();
        }
        return entity;
    }
    
    public void setEntity(Yetkililer entity) {
        this.entity = entity;
    }
    
    public YetkililerDAO getDao() {
        if (dao == null) {
            dao = new YetkililerDAO();
        }
        return dao;
    }
    
    public void setDao(YetkililerDAO dao) {
        this.dao = dao;
    }
    
    public List<Yetkililer> getList() {
        this.list = this.getDao().getList();
        return list;
    }
    
    public void setList(List<Yetkililer> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        entity = new Yetkililer();
    }
    public void delete(Yetkililer k){
        this.getDao().delete(k);
        entity = new Yetkililer();
    }
    public void clear(){
        entity = new Yetkililer();
    }

    public YetkililerBean() {

    }
}
