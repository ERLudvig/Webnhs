package controller;

import dao.BairroDAO;
import dao.CidadeDAO;
import dao.EmpresaDAO;
import java.util.List;
import model.Empresa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.Part;
import model.Bairro;
import model.Cidade;


@ManagedBean
@SessionScoped
public class EmpresaBean {

    private final String sTitle = Empresa.sTitle;
    private final String pTitle = Empresa.pTitle;

    //EMPRESA
    private Empresa empresa = new Empresa();
    private EmpresaDAO dao = new EmpresaDAO();
    private DataModel empresas;
    private List<Empresa> lstempresa;
  
    //BAIRRO
    private List<Bairro> lstbairro;
    private Bairro bairro = new Bairro();
    private BairroDAO bai_dao = new BairroDAO();

    //CIDADE
    private Cidade cidade = new Cidade();
    private List<Cidade> lstcidade;
    private CidadeDAO cid_dao = new CidadeDAO();

    public EmpresaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public DataModel getEmpresas() {
        this.empresas = new ListDataModel(dao.findAll());
        return empresas;
    }
    public List<Empresa> getLstEmpresa() {
        lstempresa = dao.findAll();
        return lstempresa;
    }

    public void setEmpresas(DataModel empresas) {
        this.empresas = empresas;
    }


    public String insert() {
        dao.insert(empresa);
        return "empresalst";
    }

    public String edit(Empresa i) {
        empresa = (Empresa) empresas.getRowData();
        return "empresafrm";
    }
    
        public List<Bairro> getLstBairro() {
        if (empresa.getEmp_cidade() == null) {
            empresa.setEmp_cidade(cid_dao.findById(lstcidade.get(0).getCid_cod()));
        }
        lstbairro = bai_dao.BairroCid(empresa.getEmp_cidade().getCid_cod());
        return lstbairro;

    }

    public List<Cidade> getLstCidade() {
        lstcidade = cid_dao.findAll();
        return lstcidade;
    }

    public String update() {
        dao.update(empresa);
        return "empresalst";
    }

    public String delete(Empresa i) {
        dao.delete(i);
        clearSession();
        return "empresalst";
    }

    public String salvar() {
        
        if (empresa.getEmp_codigo()> 0) {
            dao.update(empresa);
            
        } else {
            dao.insert(empresa);
           
        }
        clearSession();
        return "empresalst";
    }

    public String listar() {
        return "empresalst";
    }
    
     public void clearSession() {
        this.empresa = new Empresa();
        this.bairro = new Bairro();
        this.cidade = new Cidade();
    }

}
