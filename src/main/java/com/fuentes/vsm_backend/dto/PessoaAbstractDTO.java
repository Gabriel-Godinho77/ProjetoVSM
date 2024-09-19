package com.fuentes.vsm_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaAbstractDTO {

  private Long id;
  private String nome;
  private String cpforcnpj;
  private String endereco;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;
  private Long cidadeId;
  private String uf;
  private String telefone;
  private String email;

}
