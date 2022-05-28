
package dao;

/**
 *
 * @author Samet
 */



import entity.DenizUrunleri;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DenizUrunleriDAO extends DBConnection {
    public void create(DenizUrunleri k){
        try{
            Statement st = this.getConnection().createStatement();
            String query="insert into deniz_urunleri(yemek_adi,tarif,malzemeler,kac_kisilik,hazirlama_sure,pisirme_sure,sef) values"
                    + "('"+k.getYemek_adi()+"','"+k.getTarif()+"','"+k.getMalzemeler()+"','"+k.getKac_kisilik()+"','"+k.getHazirlama_sure()+"',"
                    + "'"+k.getPisirme_sure()+"','"+k.getSef()+"')";
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(DenizUrunleri k){
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update deniz_urunleri set yemek_adi='"+k.getYemek_adi()+"'where id=" +k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(DenizUrunleri k){
        try {
            Statement st = this.getConnection().createStatement();
            String query="delete from deniz_urunleri where id="+k.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List <DenizUrunleri> getList(){
        List <DenizUrunleri> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * deniz_urunleri";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                list.add(new DenizUrunleri (rs.getInt("id"),rs.getString("yemek_adi"),rs.getString("tarif"),rs.getString("malzemeler"),rs.getInt("kac_kisilik"),
                    rs.getInt("hazirlama_sure"),rs.getInt("pisirme_sure"),rs.getInt("sef")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }

}
