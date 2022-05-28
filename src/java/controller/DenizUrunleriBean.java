
package controller;
import dao.DenizUrunleriDAO;
import entity.DenizUrunleri;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;

/**
 *
 * @author Samet
 */
@Named(value = "denizUrunleriBean")
@SessionScoped
public class DenizUrunleriBean implements Serializable {
    private DenizUrunleri entity;
    private DenizUrunleriDAO dao;
    private List<DenizUrunleri> list;
    
    public DenizUrunleri getEntity(){
        if (entity == null) {
            entity = new DenizUrunleri();
        }
        return entity;
    }
    
    public void setEntity(DenizUrunleri entity) {
        this.entity = entity;
    }
    
    public DenizUrunleriDAO getDao() {
        if (dao == null) {
            dao = new DenizUrunleriDAO();
        }
        return dao;
    }
    
    public void setDao(DenizUrunleriDAO dao) {
        this.dao = dao;
    }
    
    public List<DenizUrunleri> getList() {
        this.list = this.getDao().getList();
        return list;
    }
    
    public void setList(List<DenizUrunleri> list) {
        this.list = list;
    }
    
    public void create(){
        this.getDao().create(entity);
        entity = new DenizUrunleri();
    }
    public void delete(DenizUrunleri d){
        this.getDao().delete(d);
        entity = new DenizUrunleri();
    }
    public void clear(){
        entity = new DenizUrunleri();
    }
    public void update(){
       this.getDao().update(entity);
        entity = new DenizUrunleri(); 
    }

    public DenizUrunleriBean() {

    }
}
