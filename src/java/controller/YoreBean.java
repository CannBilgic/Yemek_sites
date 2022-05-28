/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YoreDAO;
import entity.Yore;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bilgi
 */
@Named(value = "yoreBean")
@SessionScoped
public class YoreBean implements Serializable {

    private Yore entity;
    private YoreDAO dao;
    private List<Yore> list;

    public Yore getEntity() {
        if (entity == null) {
            entity = new Yore();
        }
        return entity;
    }

    public void setEntity(Yore entity) {
        this.entity = entity;
    }

    public YoreDAO getDao() {
        if (dao == null) {
            dao = new YoreDAO();
        }
        return dao;
    }

    public void setDao(YoreDAO dao) {
        this.dao = dao;
    }

    public List<Yore> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Yore> list) {
        this.list = list;
    }
    public void create() {
        this.getDao().create(entity);
        entity = new Yore();
    }

    public void delete(Yore y) {
        this.getDao().delete(y);
        entity = new Yore();
    }

    public void clear() {
        entity = new Yore();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Yore();
    }
    
    public YoreBean() {

    }
    

}
