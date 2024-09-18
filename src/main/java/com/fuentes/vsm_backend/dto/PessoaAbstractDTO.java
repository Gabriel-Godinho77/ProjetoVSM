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
  private String bairro;
  private String cep;
  private Long cidadeId;
  private String uf;
  private String telefone;
  private String email;

//public Long getId() {
//  return id;
//}
//
//public void setId(Long id) {
//  this.id = id;
//}
//
//public String getNome() {
//  return nome;
//}
//
//public void setNome(String nome) {
//  this.nome = nome;
//}
//
//public String getCpforcnpj() {
//  return cpforcnpj;
//}
//
//public void setCpforcnpj(String cpforcnpj) {
//  this.cpforcnpj = cpforcnpj;
//}
//
//public String getEndereco() {
//  return endereco;
//}
//
//public void setEndereco(String endereco) {
//  this.endereco = endereco;
//}
//
//public String getNumero() {
//  return numero;
//}
//
//public void setNumero(String numero) {
//  this.numero = numero;
//}
//
//public String getBairro() {
//  return bairro;
//}
//
//public void setBairro(String bairro) {
//  this.bairro = bairro;
//}
//
//public String getCep() {
//  return cep;
//}
//
//public void setCep(String cep) {
//  this.cep = cep;
//}
//
//public Long getCidadeId() {
//  return cidadeId;
//}
//
//public void setCidadeId(Long cidadeId) {
//  this.cidadeId = cidadeId;
//}
//
//public String getUf() {
//  return uf;
//}
//
//public void setUf(String uf) {
//  this.uf = uf;
//}
//
//public String getTelefone() {
//  return telefone;
//}
//
//public void setTelefone(String telefone) {
//  this.telefone = telefone;
//}
//
//public String getEmail() {
//  return email;
//}
//
//public void setEmail(String email) {
//  this.email = email;
//}
}
