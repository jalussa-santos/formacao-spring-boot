package com.formacao.springbootapi.controller;

import com.formacao.springbootapi.model.medico.CadastroMedicoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @PostMapping
  public void cadastrar(@RequestBody CadastroMedicoDto dados) {
    System.out.println(dados);
  }
}