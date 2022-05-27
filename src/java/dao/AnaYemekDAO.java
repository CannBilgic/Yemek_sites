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
    public void create(AnaYemek k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into ana_yemekler(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef,yorum_puan) values"
                    + "('"+k.getYemek_adi()+"','"+k.getTarif()+"','"+k.getMalzemeler()+"','"+k.getKac_kisilik()+"','"+k.getHazirlama_sure()+"',"
                    + "'"+k.getPisirme_sure()+"','"+k.getSef()+"','"+k.getYorum_puan()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(AnaYemek k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update ana_yemekler set yorum_puan='"+k.getYorum_puan()+"'where id=" +k.getId();
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
                    rs.getInt("hazirlama_sure"),rs.getInt("pisirme_sure"),rs.getInt("sef"),rs.getInt("yorum_puan")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }

}
