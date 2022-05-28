
package dao;

/**
 *
 * @author Samet
 */



import entity.Salatalar;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class SalatalarDAO extends DBConnection {
    public void create(Salatalar k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into salatalar(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef) values"
                    + "('"+k.getYemek_adi()+"','"+k.getTarif()+"','"+k.getMalzemeler()+"','"+k.getKac_kisilik()+"','"+k.getHazirlama_sure()+"',"
                    + "'"+k.getPisirme_sure()+"','"+k.getSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Salatalar k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update salatalar set yemek_adi='"+k.getYemek_adi()+"'where id=" +k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Salatalar k){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from salatalar where id="+k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <Salatalar> getList(){
        List <Salatalar> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from salatalar";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new Salatalar (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
                    rs.getInt("hazirlama_sure"),rs.getInt("pisirme_sure"),rs.getInt("sef")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }

}
