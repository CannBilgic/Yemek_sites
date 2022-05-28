/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mfurk
 */  
public class AnaYemek {
    private int id;
    private String yemek_adi;
    private String tarif;
    private String malzemeler;
    private int kac_kisilik;
    private int hazirlama_sure;
    private int pisirme_sure;
    private int sef;
    
    public AnaYemek(){
        
    }
    
    public AnaYemek(int id,String yemek_adi,String tarif,String malzemeler,int kac_kisilik,int hazirlama_sure,int pisirme_sure,int sef){
        this.id = id;
        this.yemek_adi = yemek_adi;
        this.tarif = tarif;
        this.malzemeler = malzemeler;
        this.kac_kisilik = kac_kisilik;
        this.hazirlama_sure = hazirlama_sure;
        this.pisirme_sure = pisirme_sure;
        this.sef = sef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYemek_adi() {
        return yemek_adi;
    }

    public void setYemek_adi(String yemek_adi) {
        this.yemek_adi = yemek_adi;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public int getKac_kisilik() {
        return kac_kisilik;
    }

    public void setKac_kisilik(int kac_kisilik) {
        this.kac_kisilik = kac_kisilik;
    }

    public int getHazirlama_sure() {
        return hazirlama_sure;
    }

    public void setHazirlama_sure(int hazirlama_sure) {
        this.hazirlama_sure = hazirlama_sure;
    }

    public int getPisirme_sure() {
        return pisirme_sure;
    }

    public void setPisirme_sure(int pisirme_sure) {
        this.pisirme_sure = pisirme_sure;
    }

    public int getSef() {
        return sef;
    }

    public void setSef(int sef) {
        this.sef = sef;
    }
       
    
}
