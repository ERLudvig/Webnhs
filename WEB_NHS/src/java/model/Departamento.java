package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pro_departamento")
public class Departamento implements Serializable{
    
    public static final String sTitle = "Departamento";
    public static final String pTitle = "Departamentos";
    
    @Id
    @SequenceGenerator(name = "genDepartamento", sequenceName = "genDep", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genDepartamento")
    private int dep_cod;
    private String dep_nome;

    public int getDep_cod() {
        return dep_cod;
    }

    public void setDep_cod(int dep_cod) {
        this.dep_cod = dep_cod;
    }

    public String getDep_nome() {
        return dep_nome;
    }

    public void setDep_nome(String dep_nome) {
        this.dep_nome = dep_nome;
    }
    
    
    @Override
    public int hashCode(){
    int hash = 7;
    hash = 59* hash + this.dep_cod;
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
    final Departamento other = (Departamento) obj;
    if(this.dep_cod != other.dep_cod){
    return false;
    }
    return true;
    }
    
    @Override
    public String toString(){
    return getDep_nome();
    }
}
