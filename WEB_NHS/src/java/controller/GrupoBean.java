
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.DepartamentoDAO;
import dao.GrupoDAO;
import model.Grupo;


@ManagedBean
@RequestScoped
public class GrupoBean {
    public final String sTitle = Grupo.sTitle;
    public final String pTitle = Grupo.pTitle;

    private Grupo grupo = new Grupo();
    private GrupoDAO dao = new GrupoDAO();
    private DataModel grupos;

    public GrupoBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Grupo getGrupo() {
        return grupo;
    }

  

    public GrupoDAO getDao() {
        return dao;
    }

    public void setDao(GrupoDAO dao) {
        this.dao = dao;
    }

 
   
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
      public DataModel getGrupos() {
        this.grupos = new ListDataModel(dao.findAll());
        return grupos;
    }
    
    public void setGrupos(DataModel grupos) {
        this.grupos = grupos;
    }

    

    public String insert() {
        dao.insert(grupo);
        return "grupolst";
    }

    public String edit(Grupo g) {
        grupo = (Grupo) grupos.getRowData();
        return "grupofrm";
    }

    public String update() {
        dao.update(grupo);
        return "grupolst";
    }

    public String delete(Grupo g) {
        dao.delete(g);
        return "grupolst";
    }

    public String salvar() {
        if (grupo.getGru_cod() > 0) {
            dao.update(grupo);
     } else {
            dao.insert(grupo);
       }

        return "grupolst";
    }

    public String listar() {
        return "grupolst";
    }
}
