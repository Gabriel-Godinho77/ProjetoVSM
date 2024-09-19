package com.fuentes.vsm_backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpforcnpj;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    @JsonIgnore
    private Cidade cidade;
    @JsonProperty("cidadeNome")
    public String cidadeNome(){
        return cidade.getCidadeNome();
    }
    private String uf;
    private String telefone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpforcnpj, String endereco, String numero,String complemento, String bairro, String cep, Cidade cidadeNome, String uf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpforcnpj = cpforcnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidadeNome;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
    }
}
