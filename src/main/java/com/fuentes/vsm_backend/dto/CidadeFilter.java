package com.fuentes.vsm_backend.dto;

public class CidadeFilter {
    private String nome;

    public CidadeFilter(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
