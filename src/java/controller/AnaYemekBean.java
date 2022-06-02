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
        this.list = this.getDao().getList(page, pageSize);
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
