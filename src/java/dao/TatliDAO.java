/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.AnaYemek;
import entity.Tatli;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TatliDAO extends DBConnection{
     public void create(Tatli t){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into tatlilar(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef) values"
                    + "('"+t.getYemek_adi()+"','"+t.getTarif()+"','"+t.getMalzemeler()+"','"+t.getKac_kisilik()+"','"+t.getHazirlama_sure()+"',"
                    + "'"+t.getPisirme_sure()+"','"+t.getSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Tatli t){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update tatlilar set tarif='"+t.getTarif()+"'where id=" +t.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Tatli t){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from tatlilar where id="+t.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <Tatli> getList(int page, int pageSize){
        List <Tatli> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from tatlilar order by  id  limit '"+pageSize+"'offset "+ start;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Tatli (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
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
            String query = "Select count(id) as tatli_count from tatlilar";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("tatli_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}


