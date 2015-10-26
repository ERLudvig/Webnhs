package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.BairroDAO;
import dao.CidadeDAO;
import java.util.List;
import model.Bairro;
import model.Cidade;



@ManagedBean
@RequestScoped
public class BairroBean {
    
    public final String sTitle = Bairro.sTitle;
    public final String pTitle = Bairro.pTitle;

    private Bairro bairro = new Bairro();
    private BairroDAO dao = new BairroDAO();
    private DataModel bairros;
    
    //CIDADE
    private List<Cidade> lstcidade;
    private CidadeDAO cid_dao = new CidadeDAO();

    public BairroBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }



    public BairroDAO getDao() {
        return dao;
    }

    public void setDao(BairroDAO dao) {
        this.dao = dao;
    }

 
     public Bairro getBairro() {
        return bairro;
    }
    public void setCidade(Bairro bairro) {
        this.bairro = bairro;
    }
      public DataModel getBairros() {
        this.bairros = new ListDataModel(dao.findAll());
        return bairros;
    }
    
    public void setBairros(DataModel bairros) {
        this.bairros = bairros;
    }

    

    public String insert() {
        dao.insert(bairro);
        return "bairrolst";
    }

    public String edit(Bairro b) {
        bairro = (Bairro) bairros.getRowData();
        return "bairrofrm";
    }

    public String update() {
        dao.update(bairro);
        return "bairrolst";
    }

    public String delete(Bairro b) {
        dao.delete(b);
        return "bairrolst";
    }

    public String salvar() {
        if (bairro.getBai_cod()> 0) {
            dao.update(bairro);
     } else {
            dao.insert(bairro);
       }

        return "bairrolst";
    }

    public String listar() {
        return "bairrolst";
    }
    public List<Cidade> getLstcCidade() {
       lstcidade = cid_dao.findAll();
        return lstcidade;
    }
    public DataModel getBairrosCidade(int cidade) {
        this.bairros = new ListDataModel(dao.BairroCid(cidade));
        return bairros;
    }
    
    
}
