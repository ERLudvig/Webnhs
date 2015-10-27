
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
@Table(name = "pro_produto")
public class Produto implements Serializable{
    
    public static final String sTitle = "Produto";
    public static final String pTitle = "Produtos";
    
    @Id
    @SequenceGenerator(name = "genProduto", sequenceName = "genPro", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genProduto")
    private int pro_cod;
    private String pro_nome;
    private boolean pro_ativo;
    private String pro_observacao;
    private Integer pro_q_estoque;
    private double pro_custo;
    
    @ManyToOne
    @JoinColumn(name = "dep_cod", referencedColumnName = "dep_cod")
    private Departamento pro_departamento;
    
     @ManyToOne
    @JoinColumn(name = "gru_cod", referencedColumnName = "gru_cod")
    private Grupo pro_grupo;
     
     @ManyToOne
     @JoinColumn(name = "mar_cod", referencedColumnName = "mar_cod")
    private Marca pro_marca;

    public int getPro_cod() {
        return pro_cod;
    }

    public void setPro_cod(int pro_cod) {
        this.pro_cod = pro_cod;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public boolean isPro_ativo() {
        return pro_ativo;
    }

    public void setPro_ativo(boolean pro_ativo) {
        this.pro_ativo = pro_ativo;
    }

    public String getPro_observacao() {
        return pro_observacao;
    }

    public void setPro_observacao(String pro_observacao) {
        this.pro_observacao = pro_observacao;
    }

    public Integer getPro_q_estoque() {
        return pro_q_estoque;
    }

    public void setPro_q_estoque(Integer pro_q_estoque) {
        this.pro_q_estoque = pro_q_estoque;
    }

    public double getPro_custo() {
        return pro_custo;
    }

    public void setPro_custo(double pro_custo) {
        this.pro_custo = pro_custo;
    }

    public Departamento getPro_departamento() {
        return pro_departamento;
    }

    public void setPro_departamento(Departamento pro_departamento) {
        this.pro_departamento = pro_departamento;
    }

    public Grupo getPro_grupo() {
        return pro_grupo;
    }

    public void setPro_grupo(Grupo pro_grupo) {
        this.pro_grupo = pro_grupo;
    }

    public Marca getPro_marca() {
        return pro_marca;
    }

    public void setPro_marca(Marca pro_marca) {
        this.pro_marca = pro_marca;
    }
     
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.pro_cod;
    return hash;
    }
    
    @Override
    public boolean equals (Object obj){
    if (obj == null){
    return false;
    }
    if(getClass() != obj.getClass()){
    return false;
    }
    final Produto other = (Produto) obj;
    if(this.pro_cod != other.pro_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getPro_nome();
    }
}
