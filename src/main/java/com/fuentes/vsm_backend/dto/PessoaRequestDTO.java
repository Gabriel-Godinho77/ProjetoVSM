package com.fuentes.vsm_backend.dto;

import com.fuentes.vsm_backend.entities.Pessoa;

public class PessoaRequestDTO {


     Long id;
     String nome;
     String cpforcnpj;
     String endereco;
     String numero;
     String bairro;
     String cep;
     Long cidadeId;
     String uf;
     String telefone;
     String email;

    public PessoaRequestDTO() {
    }

    public PessoaRequestDTO(Long id, String nome, String cpforcnpj, String endereco, String numero, String bairro, String cep,
                            Long cidadeId, String uf, String telefone, String email){
    }

    public PessoaRequestDTO(Pessoa dados){
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.cpforcnpj = dados.getCpforcnpj();
        this.endereco = dados.getEndereco();
        this.numero = dados.getNumero();
        this.bairro = dados.getBairro();
        this.cep = dados.getCep();
        this.cidadeId = dados.getCidade().getId();
        this.uf = dados.getUf();
        this.telefone = dados.getTelefone();
        this.email = dados.getEmail();
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

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
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
}
