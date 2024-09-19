package com.fuentes.vsm_backend.dto;

import com.fuentes.vsm_backend.entities.Pessoa;
import lombok.*;

@Getter
@Setter
@Builder
public class PessoaRequestDTO {

     Long id;
     String nome;
     String cpforcnpj;
     String endereco;
     String numero;
     String complemento;
     String bairro;
     String cep;
     Long cidadeId;
     String uf;
     String telefone;
     String email;

public PessoaRequestDTO() {
}

public PessoaRequestDTO(Long id, String nome, String cpforcnpj, String endereco, String numero,String complemento, String bairro, String cep,
                        Long cidadeId, String uf, String telefone, String email){
}

    public PessoaRequestDTO(Pessoa dados){
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.cpforcnpj = dados.getCpforcnpj();
        this.endereco = dados.getEndereco();
        this.numero = dados.getNumero();
        this.complemento = dados.getComplemento();
        this.bairro = dados.getBairro();
        this.cep = dados.getCep();
        this.cidadeId = dados.getCidade().getCidade_Id();
        this.uf = dados.getUf();
        this.telefone = dados.getTelefone();
        this.email = dados.getEmail();
    }

}
