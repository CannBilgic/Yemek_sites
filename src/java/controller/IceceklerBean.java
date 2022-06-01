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
