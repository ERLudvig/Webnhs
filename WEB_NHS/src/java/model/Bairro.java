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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bairro")
public class Bairro implements Serializable {

    public static final String sTitle = "Bairro";
    public static final String pTitle = "Bairros";

    @Id
    @SequenceGenerator(name = "bai_cod", sequenceName = "bai_cod")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bai_cod")
    private int bai_cod;
    private String bai_descricao;
    
    @ManyToOne
     @JoinColumn(name = "cid_cod", referencedColumnName = "cid_cod")
    private Cidade bai_cidade;

  

    public Bairro() {
    }

    public Bairro(int bai_cod, String bai_descricao) {
        this.bai_cod = bai_cod;
        this.bai_descricao = bai_descricao;
    }

    public int getBai_cod() {
        return bai_cod;
    }

    public void setBai_cod(int bai_cod) {
        this.bai_cod = bai_cod;
    }

    public String getBai_descricao() {
        return bai_descricao;
    }

    public void setBai_descricao(String bai_descricao) {
        this.bai_descricao = bai_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.bai_cod;
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
        final Bairro other = (Bairro) obj;
        if (this.bai_cod != other.bai_cod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getBai_descricao();
    }

    public Cidade getBai_cidade() {
        return bai_cidade;
    }

    public void setBai_cidade(Cidade bai_cidade) {
        this.bai_cidade = bai_cidade;
    }
}
