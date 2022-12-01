package com.matheusdebona.devti_persistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusdebona.devti_persistencia.model.Cidade;
import com.matheusdebona.devti_persistencia.repositories.CidadeRepository;

@Service
public class CidadeService {

  @Autowired
  CidadeRepository rep;

  public List<Cidade> buscarPorUf(String uf) {
    return rep.findByUf(uf);
  }

  public Cidade incluir(Cidade c) {
    return rep.save(c);
  }

  public List<Cidade> listarTodas() {
    return rep.findAll();
  }

  public Cidade alterar(Cidade c) {
    return rep.save(c);
  }

  public void excluir(Integer id) {
    Cidade cidadeExcluir = rep.findById(id).get();
    if (cidadeExcluir != null) {
      rep.delete(cidadeExcluir);
    }
  }
}
