package controller;

import dao.BairroDAO;
import dao.CidadeDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.PessoaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.SessionScoped;
import model.Bairro;
import model.Cidade;
import model.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaBean {

    private final String sTitle = Pessoa.sTitle;
    private final String pTitle = Pessoa.pTitle;
    //PESSOA
    private Pessoa pessoa = new Pessoa();
    private PessoaDAO dao = new PessoaDAO();
    private DataModel pessoas;
    private List<Pessoa> lstpessoa;

    //BAIRRO
    private List<Bairro> lstbairro;
    private Bairro bairro = new Bairro();
    private BairroDAO bai_dao = new BairroDAO();

    //CIDADE
    private Cidade cidade = new Cidade();
    private List<Cidade> lstcidade;
    private CidadeDAO cid_dao = new CidadeDAO();

    public PessoaBean() {
    }

    public String getsTitle() {
        return sTitle;
    }

    public String getpTitle() {
        return pTitle;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public DataModel getPessoas() {
        this.pessoas = new ListDataModel(dao.findAll());
        return pessoas;
    }

    public List<Bairro> getLstBairro() {
        if (pessoa.getPes_cidade() == null) {
            pessoa.setPes_cidade(cid_dao.findById(lstcidade.get(0).getCid_cod()));
        }
        lstbairro = bai_dao.BairroCid(pessoa.getPes_cidade().getCid_cod());
        return lstbairro;

    }

    public List<Cidade> getLstCidade() {
        lstcidade = cid_dao.findAll();
        return lstcidade;
    }

    public List<Pessoa> getLstPessoa() {
        lstpessoa = dao.findAll();
        return lstpessoa;
    }

    public String insert() {
        dao.insert(pessoa);
        return "pessoalst";
    }

    public String edit(Pessoa i) {
        pessoa = (Pessoa) pessoas.getRowData();
        return "pessoafrm";
    }
     public String view(Pessoa i) {
        pessoa = (Pessoa) pessoas.getRowData();
        return "pessoaview";
    }

    public String update() {
        dao.update(pessoa);
        return "pessoalst";
    }

    public String delete(Pessoa i) {
        try {
            dao.delete(i);
        } catch (Exception e) {
        }
        clearSession();
        return "pessoalst";
    }

    public String salvar() {
        Date data = new Date(System.currentTimeMillis());
        pessoa.setPes_datacadastro(data);
        if (pessoa.getPes_codigo() > 0) {
            dao.update(pessoa);

        } else {
            dao.insert(pessoa);

        }
        clearSession();
        return "pessoalst";
    }

    public void clearSession() {
        this.pessoa = new Pessoa();
        this.bairro = new Bairro();
        this.cidade = new Cidade();
    }

    public String listar() {
        clearSession();
        return "pessoalst";
    }
}
