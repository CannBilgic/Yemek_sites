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
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Yorum> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Yorum();
    }

    public void delete(Yorum y) {
        this.getDao().delete(y);
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
