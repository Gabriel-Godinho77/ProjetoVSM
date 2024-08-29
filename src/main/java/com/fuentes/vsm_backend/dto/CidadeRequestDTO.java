package com.fuentes.vsm_backend.dto;

import com.fuentes.vsm_backend.entities.Cidade;

public class CidadeRequestDTO {

     private Long id;
     private String nome;
     public CidadeRequestDTO(){
     }

    public CidadeRequestDTO(Long id, String nome){
    }


    public CidadeRequestDTO(Cidade entity) {
        this.id = entity.getId();
        this.nome = entity.getCidadeNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
