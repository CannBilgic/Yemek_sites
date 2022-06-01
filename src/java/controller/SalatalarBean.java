
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
    
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {

            this.page = this.getPageCount();

        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int)Math.ceil(this.getDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
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
