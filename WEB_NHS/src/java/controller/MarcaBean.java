package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.MarcaDAO;
import model.Marca;




@ManagedBean
@RequestScoped
public class MarcaBean {
    public final String sTitle = Marca.sTitle;
    public final String pTitle = Marca.pTitle;

    private Marca marca = new Marca();
    private MarcaDAO dao = new MarcaDAO();
    private DataModel marcas;

    public MarcaBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

  

  

    public MarcaDAO getDao() {
        return dao;
    }

    public void setDao(MarcaDAO dao) {
        this.dao = dao;
    }

 
     public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
      public DataModel getMarcas() {
        this.marcas = new ListDataModel(dao.findAll());
        return marcas;
    }
    
    public void setMarcas(DataModel marcas) {
        this.marcas = marcas;
    }

    

    public String insert() {
        dao.insert(marca);
        return "marcalst";
    }

    public String edit(Marca m) {
        marca = (Marca) marcas.getRowData();
        return "marcafrm";
    }

    public String update() {
        dao.update(marca);
        return "marcalst";
    }

    public String delete(Marca m) {
        dao.delete(m);
        return "marcalst";
    }

    public String salvar() {
        if (marca.getMar_cod() > 0) {
            dao.update(marca);
     } else {
            dao.insert(marca);
       }

        return "marcalst";
    }

    public String listar() {
        return "marcalst";
    }
}
