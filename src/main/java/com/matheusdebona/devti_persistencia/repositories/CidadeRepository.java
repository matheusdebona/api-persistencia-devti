package com.matheusdebona.devti_persistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusdebona.devti_persistencia.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

  public List<Cidade> findByUf(String uf);

}
