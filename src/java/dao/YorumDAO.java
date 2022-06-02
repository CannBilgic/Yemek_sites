/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanicilar;
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
public class YorumDAO extends DBConnection {

    private KullanicilarDAO kullanicilar;

    public KullanicilarDAO getKullanicilar() {
        if (kullanicilar == null) {
            this.kullanicilar = new KullanicilarDAO();
        }
        return kullanicilar;
    }

    public void setKullanicilar(KullanicilarDAO kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public void create(Yorum y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into yorum_puan(tur,yemek_id,yorum,puan,kullanici)values ('" + y.getTur() + "','" + y.getYemekId() + "','" + y.getYorum() + "','" + y.getPuan() + "','" + y.getKullanicilar().getId() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Yorum y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update yorum_puan  set yorum='" + y.getYorum() + "'where id =" + y.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Yorum y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from yorum_puan where id=" + y.getId();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Yorum> getList(int page, int pageSize) {
        List<Yorum> list = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM yorum_puan order by  id  limit '"+pageSize+"'offset "+ start ;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kullanicilar k = this.getKullanicilar().findByID(rs.getInt("id"));
                list.add(new Yorum(rs.getInt("id"), rs.getString("tur"), rs.getInt("yemek_id"), rs.getString("yorum"), rs.getInt("puan"), k));
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
            String query = "Select count(id) as yorum_count from yorum_puan";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count=rs.getInt("yorum_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
}
