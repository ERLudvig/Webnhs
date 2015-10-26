
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.CidadeDAO;
import model.Cidade;

@ManagedBean
@RequestScoped
public class CidadeBean {
    
    public final String sTitle = Cidade.sTitle;
    public final String pTitle = Cidade.pTitle;

    private Cidade cidade = new Cidade();
    private CidadeDAO dao = new CidadeDAO();
    private DataModel cidades;

    public CidadeBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }



    public CidadeDAO getDao() {
        return dao;
    }

    public void setDao(CidadeDAO dao) {
        this.dao = dao;
    }

 
     public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
      public DataModel getCidades() {
        this.cidades = new ListDataModel(dao.findAll());
        return cidades;
    }
    
    public void setCidades(DataModel cidades) {
        this.cidades = cidades;
    }

    

    public String insert() {
        dao.insert(cidade);
        return "cidadelst";
    }

    public String edit(Cidade c) {
        cidade = (Cidade) cidades.getRowData();
        return "cidadefrm";
    }

    public String update() {
        dao.update(cidade);
        return "cidadelst";
    }

    public String delete(Cidade c) {
        dao.delete(c);
        return "cidadelst";
    }

    public String salvar() {
        if (cidade.getCid_cod() > 0) {
            dao.update(cidade);
     } else {
            dao.insert(cidade);
       }

        return "cidadelst";
    }

    public String listar() {
        return "cidadelst";
    }
}
