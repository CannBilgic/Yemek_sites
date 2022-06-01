
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
