package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cx_moeda")
public class Moeda implements Serializable{
           
    public static final String sTitle = "Moeda";
    public static final String pTitle = "Moedas";
    
    @Id
    @SequenceGenerator(name = "genMoeda", sequenceName = "genMoe", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genMoeda")
    private int moe_cod;
    private String moe_nome;
    private double moe_valor;
    

    @ManyToMany(mappedBy="con_moeda")
    private List<Conta> moe_con;

    public int getMoe_cod() {
        return moe_cod;
    }

    public void setMoe_cod(int moe_cod) {
        this.moe_cod = moe_cod;
    }

    public String getMoe_nome() {
        return moe_nome;
    }

    public void setMoe_nome(String moe_nome) {
        this.moe_nome = moe_nome;
    }

    public double getMoe_valor() {
        return moe_valor;
    }

    public void setMoe_valor(double moe_valor) {
        this.moe_valor = moe_valor;
    }
   

    
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.moe_cod;
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
    final Moeda other = (Moeda) obj;
    if(this.moe_cod != other.moe_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getMoe_nome();
    }

 
}
