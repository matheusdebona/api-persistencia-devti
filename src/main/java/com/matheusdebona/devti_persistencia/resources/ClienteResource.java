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
import com.matheusdebona.devti_persistencia.model.Cliente;
import com.matheusdebona.devti_persistencia.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

  @Autowired
  ClienteService service;

  @GetMapping
  @ApiOperation(value = "Lista todos os Clientes do banco de dados")
  public List<Cliente> listarTodos() {
    return service.listarTodos();
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deleta um Cliente do banco de dados")
  public void excluir(@PathVariable("id") int id) {
    service.excluir(id);
  }

  @PutMapping
  @ApiOperation(value = "Edita um Cliente do banco de dados")
  public Cliente alterar(@RequestBody Cliente c, @RequestParam("id") int id) {
    c.setId(id);
    return service.alterar(c);
  }

  @PostMapping
  @ApiOperation(value = "Insere um Cliente no banco de dados")
  public Cliente inserirCliente(@RequestBody Cliente c) {
    return service.incluir(c);
  }

  @GetMapping("/buscaporcidade/{cidade}")
  @ApiOperation(value = "Busca um Cliente pelo nome da Cidade")
  public List<Cliente> buscaPorCidade(@PathVariable("cidade") Cidade c) {
    return service.buscarPorCidade(c);
  }

  @GetMapping("/{cidade}")
  @ApiOperation(value = "Busca Cliente pelo nome da Cidade")
  public List<Cliente> buscaPorCidade(@PathVariable("cidade") String nome) {
    return service.procuraPorNomeCidade(nome);
  }
}
