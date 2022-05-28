/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AnaYemekDAO;
import dao.AtistirmalikDAO;
import entity.AnaYemek;
import entity.Atistirmalik;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@Named(value = "atistirmalikBean")
@SessionScoped
public class AtistirmalikBean implements Serializable {

    private Atistirmalik entity;
    private AtistirmalikDAO dao;
    private List<Atistirmalik> list;

    public Atistirmalik getEntity() {
        if (entity == null) {
            entity = new Atistirmalik();
        }
        return entity;
    }

    public void setEntity(Atistirmalik entity) {
        this.entity = entity;
    }

    public AtistirmalikDAO getDao() {
        if (dao == null) {
            dao = new AtistirmalikDAO();
        }
        return dao;
    }

    public void setDao(AtistirmalikDAO dao) {
        this.dao = dao;
    }

    public List<Atistirmalik> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Atistirmalik> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Atistirmalik();
    }

    public void delete(Atistirmalik a) {
        this.getDao().delete(a);
        entity = new Atistirmalik();
    }

    public void clear() {
        entity = new Atistirmalik();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Atistirmalik();
    }

    public AtistirmalikBean() {
    }

}
