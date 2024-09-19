package com.fuentes.vsm_backend.dto;

import com.fuentes.vsm_backend.entities.Cidade;
import lombok.*;

@Getter
@Setter
@Builder
public class CidadeRequestDTO {

     private Long cidade_Id;
     private String nome;
     public CidadeRequestDTO(){
     }

    public CidadeRequestDTO(Long id, String nome){
    }


    public CidadeRequestDTO(Cidade entity) {
        this.cidade_Id = entity.getCidade_Id();
        this.nome = entity.getCidadeNome();
    }

}
