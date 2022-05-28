/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yetkililer;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfurk
 */
public class YetkililerDAO extends DBConnection{
    public void create(Yetkililer k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into yetkililer(id) values"
                    + "('"+k.getId()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Yetkililer k){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from yetkililer where id="+k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <Yetkililer> getList(){
        List <Yetkililer> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yetkililer";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Yetkililer (rs.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
