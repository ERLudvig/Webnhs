package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pro_marca")
public class Marca implements Serializable{
        
    public static final String sTitle = "Marca";
    public static final String pTitle = "Marcas";
    
    @Id
    @SequenceGenerator(name = "genMarca", sequenceName = "genMar", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genMarca")
    private int mar_cod;
    private String mar_nome;

    public int getMar_cod() {
        return mar_cod;
    }

    public void setMar_cod(int mar_cod) {
        this.mar_cod = mar_cod;
    }

    public String getMar_nome() {
        return mar_nome;
    }

    public void setMar_nome(String mar_nome) {
        this.mar_nome = mar_nome;
    }

    
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.mar_cod;
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
    final Marca other = (Marca) obj;
    if(this.mar_cod != other.mar_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getMar_nome();
    }
}
