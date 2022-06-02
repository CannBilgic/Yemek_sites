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
public class KullanicilarDAO extends DBConnection {

    public Kullanicilar findByID(int id) {
        Kullanicilar k = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM kullanicilar WHERE id="+ id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                k = new Kullanicilar(rs.getInt("id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("sehir"), rs.getInt("yas"), rs.getBoolean("cinsiyet"), rs.getBoolean("sef"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }

    public void create(Kullanicilar k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kullanicilar(kullanici_adi,sifre,sehir,yas,cinsiyet,sef) values ('" + k.getKullanici_adi() + "','" + k.getSifre() + "','" + k.getSehir() + "','" + k.getYas() + "','" + k.isCinsiyet() + "','" + k.isSef() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Kullanicilar k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kullanicilar  set sifre='" + k.getSifre() + "'where id =" + k.getId();

            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Kullanicilar k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kullanicilar where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int login(Kullanicilar k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kullanicilar where kullanici_adi='"+k.getKullanici_adi()+"' and sifre ='"+k.getSifre()+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                String query2 = "select * from yetkililer where id='"+rs.getInt("id")+"'";
                ResultSet rs2 = st.executeQuery(query2);
                if(rs2.next()){
                    return 1;
                }else{
                    return 2;
                }
            }else{
                return 3;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 3;
        }
    }
    
    public List<Kullanicilar> getList(int page, int pageSize) {
        List<Kullanicilar> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM kullanicilar order by  id  limit '"+pageSize+"'offset "+ start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kullanicilar(rs.getInt("id"), rs.getString("kullanici_adi"), rs.getString("sifre"), rs.getString("sehir"), rs.getInt("yas"), rs.getBoolean("cinsiyet"), rs.getBoolean("sef")));
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
            String query = "Select count(id) as kullanicilar_count from kullanicilar";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("kullanicilar_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
