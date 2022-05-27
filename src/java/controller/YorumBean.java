/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YorumDAO;
import entity.Yorum;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bilgi
 */
@Named(value = "yorumBean")
@SessionScoped
public class YorumBean implements Serializable {

    private Yorum entity;
    private YorumDAO dao;
    private List<Yorum> list;

    public Yorum getEntity() {
        if (entity == null) {
            entity = new Yorum();
        }
        return entity;
    }

    public void setEntity(Yorum entity) {
        this.entity = entity;
    }

    public YorumDAO getDao() {
        if (dao == null) {
            dao = new YorumDAO();
        }
        return dao;
    }

    public void setDao(YorumDAO dao) {
        this.dao = dao;
    }

    public List<Yorum> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Yorum> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Yorum();
    }

    public void delete(Yorum k) {
        this.getDao().delete(k);
        entity = new Yorum();
    }

    public void clear() {
        entity = new Yorum();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Yorum();
    }

    public YorumBean() {
    }

}
