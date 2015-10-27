package controller;

import dao.MoedaDAO;
import model.Moeda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean
@RequestScoped
public class MoedaBean {
     public final String sTitle = Moeda.sTitle;
    public final String pTitle = Moeda.pTitle;

    private Moeda moeda = new Moeda();
    private MoedaDAO dao = new MoedaDAO();
    private DataModel moedas;

    public MoedaBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

  

  

    public MoedaDAO getDao() {
        return dao;
    }

    public void setDao(MoedaDAO dao) {
        this.dao = dao;
    }

 
     public Moeda getMoeda() {
        return moeda;
    }
    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
      public DataModel getMoedas() {
        this.moedas = new ListDataModel(dao.findAll());
        return moedas;
    }
    
    public void setMoedas(DataModel moedas) {
        this.moedas = moedas;
    }

    
    

    public String insert() {
        dao.insert(moeda);
        return "moedalst";
    }

    public String edit(Moeda m) {
        moeda = (Moeda) moedas.getRowData();
        return "moedafrm";
    }

    public String update() {
        dao.update(moeda);
        return "moedalst";
    }

    public String delete(Moeda m) {
        dao.delete(m);
        return "moedalst";
    }

    public String salvar() {
        if (moeda.getMoe_cod() > 0) {
            dao.update(moeda);
     } else {
            dao.insert(moeda);
       }

        return "moedalst";
    }

    public String listar() {
        return "moedalst";
    }
}
