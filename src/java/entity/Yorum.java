/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author bilgi
 */
public class Yorum {
    private int id;
    private String yorum;
    private int puan;
    private int kullanici;

    public Yorum(int id, String yorum, int puan, int kullanici) {
        this.id = id;
        this.yorum = yorum;
        this.puan = puan;
        this.kullanici = kullanici;
    }

    public Yorum() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getKullanici() {
        return kullanici;
    }

    public void setKullanici(int kullanici) {
        this.kullanici = kullanici;
    }
    
    
    
}
