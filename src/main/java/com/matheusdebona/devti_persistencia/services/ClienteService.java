package com.matheusdebona.devti_persistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusdebona.devti_persistencia.model.Cidade;
import com.matheusdebona.devti_persistencia.model.Cliente;
import com.matheusdebona.devti_persistencia.repositories.ClienteRepository;

@Service
public class ClienteService {

  @Autowired
  ClienteRepository rep;

  public List<Cliente> listarTodos() {
    return rep.findAll();
  }

  public Cliente incluir(Cliente c) {
    return rep.save(c);
  }

  public Cliente alterar(Cliente c) {
    return rep.save(c);
  }

  public void excluir(Integer id) {
    Cliente clienteExcluir = rep.findById(id).get();
    if (clienteExcluir != null) {
      rep.delete(clienteExcluir);
    }
  }

  public List<Cliente> buscarPorCidade(Cidade cidade) {
    return rep.findByCidade(cidade);
  }
}
