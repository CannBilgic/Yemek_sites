/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Dosya;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mfurk
 */
public class DosyaDAO extends DBConnection {
    public void create(Dosya k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into dosya (dosya_ad,dosya_yol,dosya_tip) values"
                    + "('"+k.getDosya_ad()+"','"+k.getDosya_yol()+"','"+k.getDosya_tip()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Dosya k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update dosya set yemek_adi='"+k.getDosya_ad()+"'where id=" +k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Dosya k){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from dosya where id="+k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <Dosya> getList(){
        List <Dosya> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from dosya";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Dosya (rs.getInt("id"),rs.getString("dosya_ad"),rs.getString("dosya_yol"),rs.getString("dosya_tip")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
