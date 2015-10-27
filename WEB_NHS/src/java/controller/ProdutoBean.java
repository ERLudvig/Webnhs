package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.DepartamentoDAO;
import dao.GrupoDAO;
import dao.MarcaDAO;
import dao.ProdutoDAO;
import model.Departamento;
import model.Grupo;
import model.Marca;
import model.Produto;

@ManagedBean
@RequestScoped
public class ProdutoBean {
    
    public final String sTitle = Produto.sTitle;
    public final String pTitle = Produto.pTitle;

    private Produto produto = new Produto();
    private ProdutoDAO pro_dao = new ProdutoDAO();
    private DataModel produtos;
    
    private Departamento pro_departamento = new Departamento();
    private DepartamentoDAO dep_dao = new DepartamentoDAO();
    private DataModel pro_departamentos;
    private List<Departamento> lstdepartamento;
    
    private Grupo pro_grupo = new Grupo();
    private GrupoDAO gru_dao = new GrupoDAO();
    private DataModel pro_grupos;
    private List<Grupo> lstgrupo;
    
    private Marca pro_marca = new Marca();
    private MarcaDAO mar_dao = new MarcaDAO();
    private DataModel pro_marcas;
      private List<Marca> lstmarca;
    

    public ProdutoBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

  
//MARCA
  

    public MarcaDAO getDaoMarca() {
        return mar_dao;
    }

    public void setDaoMarca(MarcaDAO dao) {
        this.mar_dao = dao;
    }

     public Marca getMarca() {
        return pro_marca;
    }
    public void setMarca(Marca marca) {
        this.pro_marca = marca;
    }
      public DataModel getMarcas() {
        this.pro_marcas = new ListDataModel(mar_dao.findAll());
        return pro_marcas;
    }
    
    public void setMarcas(DataModel marcas) {
        this.pro_marcas = marcas;
    }

    //    public List<Marca> completeMarca(String query) {
//        List<Marca> lsC = mar_dao.searchMarca(query);
//        return lsC;
//    }
    
    public List<Marca> getLstMarca() {
       lstmarca = mar_dao.findAll();
        return lstmarca;
    }
    
    //PRODUTO
    
     public ProdutoDAO getDaoProduto() {
        return pro_dao;
    }

    public void setDaoProduto(ProdutoDAO dao) {
        this.pro_dao = dao;
    }

     public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
      public DataModel getProdutos() {
        this.produtos = new ListDataModel(pro_dao.findAll());
        return produtos;
    }
    
    public void setProdutos(DataModel produtos) {
        this.produtos = produtos;
    }
    
    //DEPARTAMENTO
    
    public DepartamentoDAO getDaoDepartamento() {
        return dep_dao;
    }

    public void setDaoDepartamento(DepartamentoDAO dao) {
        this.dep_dao = dao;
    }

     public Departamento getDepartamento() {
        return pro_departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.pro_departamento = departamento;
    }
      public DataModel getDepartamentos() {
        this.pro_departamentos = new ListDataModel(dep_dao.findAll());
        return pro_departamentos;
    }
    
    public void setDepartamentos(DataModel departamentos) {
        this.pro_departamentos = departamentos;
    }
    public List<Departamento> getLstDepartamento() {
       lstdepartamento = dep_dao.findAll();
        return lstdepartamento;
    }
    
    //GRUPO
    public GrupoDAO getDaoGrupo() {
        return gru_dao;
    }

    public void setDaoGrupo(GrupoDAO dao) {
        this.gru_dao = dao;
    }

     public Grupo getGrupo() {
        return pro_grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.pro_grupo = grupo;
    }
      public DataModel getGrupos() {
        this.pro_grupos = new ListDataModel(gru_dao.findAll());
        return pro_grupos;
    }
    
    public void setGrupos(DataModel grupos) {
        this.pro_marcas = grupos;
    }
    
    public List<Grupo> getLstGrupo() {
       lstgrupo = gru_dao.findAll();
        return lstgrupo;
    }
    //-----------------------------------------------------------------------------------
    

    public String insertProduto() {
        pro_dao.insert(produto);
        return "produtolst";
    }

    public String edit(Produto p) {
        produto = (Produto) produtos.getRowData();
        return "produtofrm";
    }

    public String update() {
        pro_dao.update(produto);
        return "produtolst";
    }

    public String delete(Produto p) {
        pro_dao.delete(p);
        return "produtolst";
    }

    public String salvar() {
        if (produto.getPro_cod() > 0) {
            pro_dao.update(produto);
     } else {
            pro_dao.insert(produto);
       }

        return "produtolst";
    }

    public String listar() {
        return "produtolst";
    }
    

    
    
}
