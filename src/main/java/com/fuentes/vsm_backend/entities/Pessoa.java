package com.fuentes.vsm_backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.io.Serializable;

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

    public Pessoa(Long id, String nome, String cpforcnpj, String endereco, String numero, String bairro, String cep, Cidade cidadeNome, String uf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpforcnpj = cpforcnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidadeNome;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
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

    public String getCpforcnpj() {
        return cpforcnpj;
    }

    public void setCpforcnpj(String cpforCnpj) {
        this.cpforcnpj = cpforCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }




}
