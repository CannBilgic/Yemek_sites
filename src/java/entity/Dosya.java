/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mfurk
 */
public class Dosya {
    private int id;
    private String dosya_ad;
    private String dosya_yol;
    private String dosya_tip;

    public Dosya() {
    }

    public Dosya(int id, String dosya_ad, String dosya_yol, String dosya_tip) {
        this.id = id;
        this.dosya_ad = dosya_ad;
        this.dosya_yol = dosya_yol;
        this.dosya_tip = dosya_tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosya_ad() {
        return dosya_ad;
    }

    public void setDosya_ad(String dosya_ad) {
        this.dosya_ad = dosya_ad;
    }

    public String getDosya_yol() {
        return dosya_yol;
    }

    public void setDosya_yol(String dosya_yol) {
        this.dosya_yol = dosya_yol;
    }

    public String getDosya_tip() {
        return dosya_tip;
    }
    
    public void setDosya_tip(String dosya_tip) {
        this.dosya_tip = dosya_tip;
    }

    
}
