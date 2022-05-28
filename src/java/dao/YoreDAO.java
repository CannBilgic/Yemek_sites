/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yore;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilgi
 */
public class YoreDAO extends DBConnection {

    public void create(Yore y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into yoreseller(id,yore) values"
                    + "('" + y.getId() + "','" + y.getYore()+ "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Yore y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update yoreseller set yore='" + y.getYore() + "'where id=" + y.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Yore y) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from yoreseller where id=" + y.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Yore> getList() {
        List<Yore> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yoreseller";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Yore(rs.getInt("id"), rs.getString("yore")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

}
