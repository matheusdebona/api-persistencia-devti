package com.matheusdebona.devti_persistencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "Chave primária do Cliente")
  private Integer id;

  @Column
  @ApiModelProperty(value = "Nome do Cliente")
  private String nome;

  @Column
  @ApiModelProperty(value = "Sexo do Cliente")
  private String sexo;

  @Column
  @ApiModelProperty(value = "Idade do Cliente")
  private Integer idade;

  @ManyToOne
  @ApiModelProperty(value = "Cidade do Cliente")
  private Cidade cidade;

  public Cliente() {
    this(0, "", "", 0, null);
  }

  public Cliente(Integer id, String nome, String sexo, Integer idade, Cidade cidade) {
    this.id = id;
    this.nome = nome;
    this.sexo = sexo;
    this.idade = idade;
    this.cidade = cidade;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
