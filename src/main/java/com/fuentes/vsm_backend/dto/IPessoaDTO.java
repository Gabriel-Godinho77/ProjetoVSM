package com.fuentes.vsm_backend.dto;

public interface IPessoaDTO {

    public Long getId();
    public String getNome();
    public String getCpforcnpj();
    public String getEndereco();
    public String getNumero();
    public String getComplemento();
    public String getBairro();
    public String getCep();
    public Long getCidadeId();
    public String getUf();
    public String getTelefone();
    public String getEmail();

     public default PessoaAbstractDTO toPessoaRequestDto(){
         return PessoaAbstractDTO.builder()
                 .id(this.getId())
                 .nome(this.getNome())
                 .cpforcnpj(this.getCpforcnpj())
                 .endereco(this.getEndereco())
                 .numero(this.getNumero())
                 .complemento(this.getComplemento())
                 .bairro(this.getBairro())
                 .cep(this.getCep())
                 .cidadeId(this.getCidadeId())
                 .uf(this.getUf())
                 .telefone(this.getTelefone())
                 .email(this.getEmail())
                 .build();
    }


}
