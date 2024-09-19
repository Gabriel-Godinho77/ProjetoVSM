package com.fuentes.vsm_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaResponseDTO {

   private String nome;
   private String cpforcnpj;
   private String cidadeNome;
   private String uf;
   private String telefone;
   private String email;

}
