package com.fuentes.vsm_backend.dto;

public interface ICidadeDTO {

    public Long getCidade_Id();
    public String getCidadeNome();

    public default CidadeAbstractDTO toCidadeRequestDTO(){
        return CidadeAbstractDTO.builder()
                .cidade_Id(this.getCidade_Id())
                .cidadeNome(this.getCidadeNome())
                .build();
    }

}
