
package controller;
import dao.SalatalarDAO;
import entity.Salatalar;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

/**
 *
 * @author Samet
 */
@Named(value = "salatalarBean")
@SessionScoped
public class SalatalarBean implements Serializable {
    private Salatalar entity;
    private SalatalarDAO dao;
    private List<Salatalar> list;
    
    public Salatalar getEntity(){
        if (entity == null) {
            entity = new Salatalar();
        }
        return entity;
    }
    
    public void setEntity(Salatalar entity) {
        this.entity = entity;
    }
    
    public SalatalarDAO getDao() {
        if (dao == null) {
            dao = new SalatalarDAO();
        }
        return dao;
    }
    
    public void setDao(SalatalarDAO dao) {
        this.dao = dao;
    }
    
    public List<Salatalar> getList() {
        this.list = this.getDao().getList();
        return list;
    }
    
    public void setList(List<Salatalar> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        entity = new Salatalar();
    }
    public void delete(Salatalar s){
        this.getDao().delete(s);
        entity = new Salatalar();
    }
    public void clear(){
        entity = new Salatalar();
    }
    public void update(){
       this.getDao().update(entity);
        entity = new Salatalar(); 
    }

    public SalatalarBean() {

    }
}
