/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.AnaYemek;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfurk
 */
public class AnaYemekDAO extends DBConnection {
    
    public AnaYemek findByID(int id) {
        AnaYemek k = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM ana_yemekler WHERE id="+ id;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                k = new AnaYemek (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
                rs.getInt("hazirlama_sure"),rs.getInt("pisirme_sure"),rs.getInt("sef"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }
    
    public void create(AnaYemek k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into ana_yemekler(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef) values"
                    + "('"+k.getYemek_adi()+"','"+k.getTarif()+"','"+k.getMalzemeler()+"','"+k.getKac_kisilik()+"','"+k.getHazirlama_sure()+"',"
                    + "'"+k.getPisirme_sure()+"','"+k.getSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(AnaYemek k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update ana_yemekler set tarif='"+k.getTarif()+"'where id=" +k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(AnaYemek k){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from ana_yemekler where id="+k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <AnaYemek> getList(){
        List <AnaYemek> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from ana_yemekler";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new AnaYemek (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
                    rs.getInt("hazirlama_sure"),rs.getInt("pisirme_sure"),rs.getInt("sef")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select count(id) as anayemek_count from ana_yemekler";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("anayemek_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
