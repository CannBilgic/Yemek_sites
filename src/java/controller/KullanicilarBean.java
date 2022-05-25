/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullanicilarDAO;
import entity.Kullanicilar;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

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
    public void delete(){
        this.getDao().delete(entity);
        entity = new Kullanicilar();
    }

    public KullanicilarBean() {

    }

}
