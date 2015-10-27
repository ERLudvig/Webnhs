package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pro_grupo")
public class Grupo implements Serializable{
          
    public static final String sTitle = "Grupo";
    public static final String pTitle = "Grupos";
    
    @Id
    @SequenceGenerator(name = "genGrupo", sequenceName = "genGru", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genGrupo")
    private int gru_cod;
    private String gru_nome;

    public int getGru_cod() {
        return gru_cod;
    }

    public void setGru_cod(int gru_cod) {
        this.gru_cod = gru_cod;
    }

    public String getGru_nome() {
        return gru_nome;
    }

    public void setGru_nome(String gru_nome) {
        this.gru_nome = gru_nome;
    }

    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.gru_cod;
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
    final Grupo other = (Grupo) obj;
    if(this.gru_cod != other.gru_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getGru_nome();
    }
}
