/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
    
    public static final String sTitle = "Cidade";
    public static final String pTitle = "Cidades";
    
    @Id
    @SequenceGenerator(name = "cid_codigo", sequenceName = "cid_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cid_codigo")
    private int cid_cod;
    private String cid_nome;
    
   
   

    public Cidade() {
    }

    public int getCid_cod() {
        return cid_cod;
    }

    public void setCid_cod(int cid_codigo) {
        this.cid_cod = cid_codigo;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.cid_cod;
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
        final Cidade other = (Cidade) obj;
        if (this.cid_cod != other.cid_cod) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return getCid_nome();
    }


}
