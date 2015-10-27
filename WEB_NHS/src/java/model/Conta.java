package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cx_conta")
public class Conta implements Serializable{
           
    public static final String sTitle = "Conta";
    public static final String pTitle = "Contas";
    
    @Id
    @SequenceGenerator(name = "genConta", sequenceName = "genCon", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genConta")
    private int con_cod;
    private String con_nome;
    private double con_saldo;
    
  
    @ManyToMany
    @JoinTable(name = "con_moe", joinColumns = @JoinColumn(name = "con_cod"), inverseJoinColumns = @JoinColumn(name = "moe_cod"))
    private List<Moeda> con_moeda;

    
    
    
    
    
    
    
    public int getCon_cod() {
        return con_cod;
    }

    public void setCon_cod(int con_cod) {
        this.con_cod = con_cod;
    }

    public String getCon_nome() {
        return con_nome;
    }

    public void setCon_nome(String con_nome) {
        this.con_nome = con_nome;
    }

    public double getCon_saldo() {
        return con_saldo;
    }

    public void setCon_saldo(double con_saldo) {
        this.con_saldo = con_saldo;
    }

   


    
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.con_cod;
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
    final Conta other = (Conta) obj;
    if(this.con_cod != other.con_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getCon_nome();
    }
}
