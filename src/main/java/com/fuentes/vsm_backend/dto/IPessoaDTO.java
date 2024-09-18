package com.fuentes.vsm_backend.dto;

public interface IPessoaDTO {

    public Long getId();
    public String getNome();
    public String getCpforcnpj();
    public String getEndereco();
    public String getNumero();
    public String getBairro();
    public String getCep();
    public Long getCidadeId();
    public String getCidadeNome();
    public String getUf();
    public String getTelefone();
    public String getEmail();

     public default PessoaAbstractDTO toPessoaRequestDto(){
        PessoaAbstractDTO pessoaAbstractDTO= new PessoaAbstractDTO();
        pessoaAbstractDTO.setId(this.getId());
        pessoaAbstractDTO.setNome(this.getNome());
        pessoaAbstractDTO.setCpforcnpj(this.getCpforcnpj());
        pessoaAbstractDTO.setEndereco(this.getEndereco());
        pessoaAbstractDTO.setNumero(this.getNumero());
        pessoaAbstractDTO.setBairro(this.getBairro());
        pessoaAbstractDTO.setCep(this.getCep());
        pessoaAbstractDTO.setCidadeId(this.getCidadeId());
        pessoaAbstractDTO.setUf(this.getUf());
        pessoaAbstractDTO.setTelefone(this.getTelefone());
        pessoaAbstractDTO.setEmail(this.getEmail());
        return pessoaAbstractDTO;


    }


}
