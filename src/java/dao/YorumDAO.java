/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yorum;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author bilgi
 */
public class YorumDAO extends DBConnection{
    public void create(Yorum y){
        int i =0;
        try{
            Statement  st =this.getConnection().createStatement();
            String query="insert into yorum_puan(yorum,puan,kullanici)values ('"+y.getYorum()+"','"+y.getPuan()+"','"+y.getKullanici()+"')";
            st.executeUpdate(query);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void update (Yorum y){
        try{
            Statement st = this.getConnection().createStatement();
            String query="update yorum_puan  set yorum='"+y.getYorum()+"'where id ="+y.getId();
            st.executeUpdate(query);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void delete(Yorum y){
        try{
            Statement st = this.getConnection().createStatement();
            String query="delete from yorum_puan where id="+y.getId();
            st.executeUpdate(query);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public List <Yorum> getList(){
        List <Yorum> list = new ArrayList<>();
        try{
            Statement st =this.getConnection().createStatement();
            String query="Select * from yorum_puan";
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                list.add(new Yorum (rs.getInt("id"),rs.getString("yorum"),rs.getInt("puan"),rs.getInt("kullanici")));
            }
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}