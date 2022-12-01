package com.matheusdebona.devti_persistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusdebona.devti_persistencia.model.Cidade;
import com.matheusdebona.devti_persistencia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  public List<Cliente> findByCidade(Cidade c);

}
