package com.fuentes.vsm_backend.entities;

import com.fuentes.vsm_backend.dto.CidadeResponseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "cidades")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidade_Id;
    private String cidadeNome;


    public Cidade() {
    }

    public Cidade(Long cidade_Id, String cidadeNome) {
        this.cidade_Id = cidade_Id;
        this.cidadeNome = cidadeNome;
    }

    public CidadeResponseDTO toCidadeResponseDTO(){
        return CidadeResponseDTO.builder()
                .cidadeNome(this.getCidadeNome())
                .build();
    }
}
