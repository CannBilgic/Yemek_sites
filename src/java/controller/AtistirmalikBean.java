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
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {

            this.page = this.getPageCount();

        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int)Math.ceil(this.getDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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
        this.list = this.getDao().getList(page, pageSize);
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
