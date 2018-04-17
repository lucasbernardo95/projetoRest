/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.projeto.model;





/**
 *
 * @author Aluno
 */
public class Mensagem {
    private long id;
    private String conteudo;

    public Mensagem(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public Mensagem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "id=" + id + ", conteudo=" + conteudo + '}';
    }
    
}
