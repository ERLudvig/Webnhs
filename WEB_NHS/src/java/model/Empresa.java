package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    public static final String sTitle = "Empresa";
    public static final String pTitle = "Empresas";

    @Id
    @SequenceGenerator(name = "emp_codigo", sequenceName = "emp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_codigo")
 
    private int emp_codigo;
    private String emp_nome;
    private int emp_genero;
    /**
     * 1 - Cliente
     * 2 - Fornecedor
     */
    private int emp_tipo;
    /**
     * 1 - Empresa Privada 
     * 2 - Empresa Pública 
     * 3 - Escola Privada 
     * 4 - Escola Pública
     */
      @ManyToOne
     @JoinColumn(name = "cid_cod", referencedColumnName = "cid_cod")
    private Cidade emp_cidade;
    
    @ManyToOne
     @JoinColumn(name = "bai_cod", referencedColumnName = "bai_cod")
    private Bairro emp_bairro;
    private String emp_cnpj;
    private int emp_tamanho;
    /**
     * 1 - Familiar 
     * 2 - Pequena 
     * 3 - Média 
     * 4 - Grande 
     * 5 - Global 
     */
    private String emp_descricao;
    private String emp_website;

    public Empresa() {
    }

    public int getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(int emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getEmp_nome() {
        return emp_nome;
    }

    public void setEmp_nome(String emp_nome) {
        this.emp_nome = emp_nome;
    }

    public int getEmp_tipo() {
        return emp_tipo;
    }

    public void setEmp_tipo(int emp_tipo) {
        this.emp_tipo = emp_tipo;
    }

    public int getEmp_tamanho() {
        return emp_tamanho;
    }

    public void setEmp_tamanho(int emp_tamanho) {
        this.emp_tamanho = emp_tamanho;
    }

    public String getEmp_descricao() {
        return emp_descricao;
    }

    public void setEmp_descricao(String emp_descricao) {
        this.emp_descricao = emp_descricao;
    }

    public String getEmp_website() {
        return emp_website;
    }

    public void setEmp_website(String emp_website) {
        this.emp_website = emp_website;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.emp_codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.emp_codigo != other.emp_codigo) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return getEmp_nome();
    }

    public Cidade getEmp_cidade() {
        return emp_cidade;
    }

    public void setEmp_cidade(Cidade emp_cidade) {
        this.emp_cidade = emp_cidade;
    }

    public Bairro getEmp_bairro() {
        return emp_bairro;
    }

    public void setEmp_bairro(Bairro emp_bairro) {
        this.emp_bairro = emp_bairro; 
    }

    public String getEmp_cnpj() {
        return emp_cnpj;
    }

    public void setEmp_cnpj(String emp_cnpj) {
        this.emp_cnpj = emp_cnpj;
    }

    public int getEmp_genero() {
        return emp_genero;
    }

    public void setEmp_genero(int emp_genero) {
        this.emp_genero = emp_genero;
    }
    
}
