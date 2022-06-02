/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DosyaDAO;
import entity.Dosya;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.nio.file.Paths;

/**
 *
 * @author mfurk
 */
@Named(value = "dosyaBean")
@SessionScoped
public class DosyaBean implements Serializable{
    private Dosya entity;
    private List<Dosya> list;
    private DosyaDAO dao;

    private Part doc; 
    
    //DOSYA YOLU HER BİLGİSAYARDA DEGİSKENDİR
   // private String uploadTo = "C:/Users/mfurk/OneDrive/Belgeler/NetBeansProjects/yemek_site/Yemek_sites/web/resimler/";
    private String uploadTo = "C:/Users/bilgi/OneDrive/Belgeler/NetBeansProjects/YemekSitesi/web/resimler/";
    public void upload() {
        
        try {
            InputStream input = getDoc().getInputStream();
            File f = new File(this.getUploadTo() + Paths.get(getDoc().getSubmittedFileName()).getFileName().toString());
            Files.copy(input, f.toPath());
            
            entity = this.getEntity();
            entity.setDosya_ad(f.getName());
            entity.setDosya_yol(f.getParent());
            entity.setDosya_tip(doc.getContentType());

            this.getDao().create(entity);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getUploadTo() {
        return uploadTo;
    }
    
    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    public Dosya getEntity() {
        if (entity == null) {
            entity = new Dosya();
        }
        return entity;
    }

    public void setEntity(Dosya entity) {
        this.entity = entity;
    }

    public DosyaDAO getDao() {
        if (dao == null) {
            dao = new DosyaDAO();
        }
        return dao;
    }

    public void setDao(DosyaDAO dao) {
        this.dao = dao;
    }

    public List<Dosya> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Dosya> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Dosya();
    }

    public void delete(Dosya t) {
        this.getDao().delete(t);
        entity = new Dosya();
    }

    public void clear() {
        entity = new Dosya();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Dosya();
    }

    public DosyaBean() {

    }
}
