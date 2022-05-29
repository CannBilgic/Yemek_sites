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
    private String tur;
    private int yemekId;
    private String yorum;
    private int puan;
    private Kullanicilar kullanicilar;

    public Yorum(int id, String tur, int yemekId, String yorum, int puan, Kullanicilar kullanicilar) {
        this.id = id;
        this.tur = tur;
        this.yemekId = yemekId;
        this.yorum = yorum;
        this.puan = puan;
        this.kullanicilar = kullanicilar;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getYemekId() {
        return yemekId;
    }

    public void setYemekId(int yemekId) {
        this.yemekId = yemekId;
    }

    public Yorum(int id) {
        this.id = id;
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

    public Kullanicilar getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(Kullanicilar kullanicilar) {
        this.kullanicilar = kullanicilar;
    }
    
    
}
