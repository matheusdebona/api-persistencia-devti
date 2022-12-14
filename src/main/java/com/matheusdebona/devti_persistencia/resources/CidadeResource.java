package com.matheusdebona.devti_persistencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matheusdebona.devti_persistencia.model.Cidade;
import com.matheusdebona.devti_persistencia.services.CidadeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

  @Autowired
  CidadeService service;

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deleta uma Cidade no banco de dados")
  public void excluir(@PathVariable("id") int id) {
    service.excluir(id);
  }

  @PutMapping
  @ApiOperation(value = "Altera uma Cidade no banco de dados")
  public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") int id) {
    c.setId(id);
    return service.alterar(c);
  }

  @PostMapping
  @ApiOperation(value = "Insere uma Cidade no banco de dados")
  public Cidade inserirCidade(@RequestBody Cidade c) {
    return service.incluir(c);

  }

  @GetMapping
  @ApiOperation(value = "Lista todas as Cidades no banco de dados")
  public List<Cidade> listarTodas() {
    return service.listarTodas();
  }

  @GetMapping("/buscauf/{uf}")
  @ApiOperation(value = "Busca uma Cidade no banco de dados pela UF")
  public List<Cidade> listarPorUf(@PathVariable("uf") String uf) {
    return service.buscarPorUf(uf);
  }

}
