package controller;


import dao.ContaDAO;
import dao.MoedaDAO;
import java.util.ArrayList;
import model.Conta;
import model.Moeda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@RequestScoped
public class ContaBean {
    
    
    public final String sTitle = Conta.sTitle;
    public final String pTitle = Conta.pTitle;

    //CONTA
    private Conta conta = new Conta();
    private ContaDAO dao = new ContaDAO();
    private DataModel contas;
    private DataModel<Conta> lstcontas;
   
    //CONTA MOEDA


     
     //MOEDA
     
    private Moeda moeda = new Moeda();
    private MoedaDAO dao_moeda = new MoedaDAO();
    private DataModel moedas;
    private List<Moeda> lstmoedas;
     
     
    public ContaBean() {

    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

     public String selectConta() {
        conta = lstcontas.getRowData();
        return "contaview";
    }

     public DataModel<Conta> getHMoedas() {
        this.contas = new ListDataModel(dao.BuscaConta(conta.getCon_cod()));
        return lstcontas;
    }
     
 
    
  
  

    public ContaDAO getDao() {
        return dao;
    }

    public void setDao(ContaDAO dao) {
        this.dao = dao;
    }

 

    
    
     public Conta getConta() {
        return conta;
    }
    public void setConta (Conta conta) {
        this.conta = conta;
    }
      public DataModel getContas() {
        this.contas = new ListDataModel(dao.findAll());
        return contas;
    }
    
    public void setContas(DataModel contas) {
        this.contas = contas;
    }

    

    public String insert() {
        dao.insert(conta);
        return "contalst";
    }

    public String edit(Conta c) {
        conta = (Conta) contas.getRowData();
        return "contafrm";
    }

    public String update() {
        dao.update(conta);
        return "contalst";
    }

    public String delete(Conta c) {
        dao.delete(c);
        return "contalst";
    }

    public String salvar() {
        if (conta.getCon_cod() > 0) {
            dao.update(conta);
     } else {
            dao.insert(conta);
       }

        return "contalst";
    }

    public String listar() {
        return "contalst";
    }

    public DataModel<Conta> getLstcontas() {
        return lstcontas;
    }

    public void setLstcontas(DataModel<Conta> lstcontas) {
        this.lstcontas = lstcontas;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public MoedaDAO getDao_moeda() {
        return dao_moeda;
    }

    public void setDao_moeda(MoedaDAO dao_moeda) {
        this.dao_moeda = dao_moeda;
    }

    public DataModel getMoedas() {
        return moedas;
    }

    public void setMoedas(DataModel moedas) {
        this.moedas = moedas;
    }

     public List<Moeda> getLstMoeda() {
        lstmoedas = dao_moeda.findAll();
        return lstmoedas;
    }

    public void setLstmoedas(List<Moeda> lstmoedas) {
        this.lstmoedas = lstmoedas;
    }
//     public void addMoeda() {
//        if (moeda != null) {
//            if (con_moeda.get.getLsProdutoMaquina() == null) {
//                produto.setLsProdutoMaquina(new ArrayList<ProdutoMaquina>());
//            }
//            boolean bAdd = true;
//            for (ProdutoMaquina pm : produto.getLsProdutoMaquina()) {
//                if (pm.getMaquina().getMaq_id() == maquina.getMaq_id()) {
//                    bAdd = false;
//                }
//            }
//            if (bAdd) {
//                ProdutoMaquina pm = new ProdutoMaquina();
//                pm.setMaquina(maquina);
//                pm.setProduto(produto);
//                produto.getLsProdutoMaquina().add(pm);
//            }
//            reloadMaquinas();
//        }
//    }
//     public List<ContaMoeda> getLsProdutoMaquina() {
//        return lsProdutoMaquina;
//    }
}
