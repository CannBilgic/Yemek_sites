/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.Atistirmalik;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AtistirmalikDAO extends DBConnection{
     public void create(Atistirmalik a){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into atistirmalik(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef) values"
                    + "('"+a.getYemek_adi()+"','"+a.getTarif()+"','"+a.getMalzemeler()+"','"+a.getKac_kisilik()+"','"+a.getHazirlama_sure()+"',"
                    + "'"+a.getPisirme_sure()+"','"+a.getSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Atistirmalik a){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update atistirmalik set tarif='"+a.getTarif()+"'where id=" +a.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Atistirmalik a){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from atistirmalik where id="+a.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <Atistirmalik> getList(int page, int pageSize){
        List <Atistirmalik> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from atistirmalik order by  id  limit '"+pageSize+"'offset "+ start;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Atistirmalik (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
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
            String query = "Select count(id) as at_count from atistirmalik";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("at_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}


