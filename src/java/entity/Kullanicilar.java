/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author can
 */
public class Kullanicilar {
    private int id;
    private String kullanici_adi;
    private String Sifre;
    private String Sehir;
    private int yas;
    private boolean cinsiyet;
    private boolean sef;

    public Kullanicilar() {
    }
    

    public Kullanicilar(int id, String kullanici_adi, String Sifre, String Sehir, int yas, boolean cinsiyet, boolean sef) {
        this.id = id;
        this.kullanici_adi = kullanici_adi;
        this.Sifre = Sifre;
        this.Sehir = Sehir;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.sef = sef;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }

    public String getSehir() {
        return Sehir;
    }

    public void setSehir(String Sehir) {
        this.Sehir = Sehir;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public boolean isCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(boolean cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public boolean isSef() {
        return sef;
    }

    public void setSef(boolean sef) {
        this.sef = sef;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kullanicilar other = (Kullanicilar) obj;
        return this.id == other.id;
    }

    
    
}