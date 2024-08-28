package com.fuentes.vsm_backend.dto;

public class PessoaFilter {

    private String nome;

    public PessoaFilter(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
