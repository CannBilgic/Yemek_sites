package dao;

import entity.Kullanicilar;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author can
 */
public class KullanicilarDAO extends DBConnection{
    public void create(Kullanicilar k){
        try{
            Statement st =this.getConnection().createStatement();
            String query="insert into kullanicilar(id,kullanici_adi,sifre,sehir,yas,cinsiyet,sef) values ('"+ k.getId()+"','"+k.getKullanici_adi()+"','"+ k.getSifre()+"','"+ k.getSehir()+"','"+ k.getYas()+"','"+ k.isCinsiyet()+"','"+ k.isSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Kullanicilar k){
        try{
            Statement st =this.getConnection().createStatement();
            String query="update kullanicilar  set sifre='"+k.getSifre()+"'where id ="+k.getId();
            
            st.executeUpdate(query) ;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Kullanicilar k){
        try{
            Statement st =this.getConnection().createStatement();
            String query="delete from kullanicilar where id="+k.getId();
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public List <Kullanicilar> getList(){
        List <Kullanicilar> list = new ArrayList<>();
        try{
            Statement st =this.getConnection().createStatement();
            String query="Select * from kullanicilar";
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                list.add(new Kullanicilar (rs.getInt("id"),rs.getString("kullanici_adi"),rs.getString("sifre"),rs.getString("sehir"),rs.getInt("yas"),rs.getBoolean("cinsiyet"),rs.getBoolean("sef")));
            }
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
