package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.DepartamentoDAO;
import model.Departamento;

@ManagedBean
@RequestScoped
public class DepartamentoBean {
    public final String sTitle = Departamento.sTitle;
    public final String pTitle = Departamento.pTitle;

    private Departamento departamento = new Departamento();
    private DepartamentoDAO dao = new DepartamentoDAO();
    private DataModel departamentos;

    public DepartamentoBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

  

  

    public DepartamentoDAO getDao() {
        return dao;
    }

    public void setDao(DepartamentoDAO dao) {
        this.dao = dao;
    }

 
     public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
      public DataModel getDepartamentos() {
        this.departamentos = new ListDataModel(dao.findAll());
        return departamentos;
    }
    
    public void setDepartamentos(DataModel departamentos) {
        this.departamentos = departamentos;
    }

    

    public String insert() {
        dao.insert(departamento);
        return "departamentolst";
    }

    public String edit(Departamento d) {
        departamento = (Departamento) departamentos.getRowData();
        return "departamentofrm";
    }

    public String update() {
        dao.update(departamento);
        return "departamentolst";
    }

    public String delete(Departamento f) {
        dao.delete(f);
        return "departamentolst";
    }

    public String salvar() {
        if (departamento.getDep_cod() > 0) {
            dao.update(departamento);
     } else {
            dao.insert(departamento);
       }

        return "departamentolst";
    }

    public String listar() {
        return "departamentolst";
    }
}
