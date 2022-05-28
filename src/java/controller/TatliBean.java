/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;


import dao.TatliDAO;
import entity.Tatli;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@Named(value = "tatliBean")
@SessionScoped
public class TatliBean implements Serializable {

    private Tatli entity;
    private TatliDAO dao;
    private List<Tatli> list;

    public Tatli getEntity() {
        if (entity == null) {
            entity = new Tatli();
        }
        return entity;
    }

    public void setEntity(Tatli entity) {
        this.entity = entity;
    }

    public TatliDAO getDao() {
        if (dao == null) {
            dao = new TatliDAO();
        }
        return dao;
    }

    public void setDao(TatliDAO dao) {
        this.dao = dao;
    }

    public List<Tatli> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Tatli> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Tatli();
    }

    public void delete(Tatli t) {
        this.getDao().delete(t);
        entity = new Tatli();
    }

    public void clear() {
        entity = new Tatli();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Tatli();
    }

    public TatliBean() {

    }
}
