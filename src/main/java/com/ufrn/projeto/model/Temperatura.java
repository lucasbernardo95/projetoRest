/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.projeto.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "TEMPERATURA")
public class Temperatura implements Serializable {

    @Id
    @Column(name = "id_temperatura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String value;
    
    @Column(name = "data_coleta", nullable = false)
    private Date dataColeta;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 97 * hash + (this.dataColeta != null ? this.dataColeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Temperatura other = (Temperatura) obj;
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.dataColeta != other.dataColeta && (this.dataColeta == null || !this.dataColeta.equals(other.dataColeta))) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Temperatura{" + "id=" + id + ", value=" + value + ", data_coleta=" + dataColeta + '}';
    }

}
