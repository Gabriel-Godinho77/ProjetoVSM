package com.fuentes.vsm_backend.dto;

public class PessoaResponseDTO {

   private String nome;
   private String cpforcnpj;
   private String cidadeNome;
   private String uf;
   private String telefone;
   private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpforcnpj() {
        return cpforcnpj;
    }

    public void setCpforcnpj(String cpforcnpj) {
        this.cpforcnpj = cpforcnpj;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
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
