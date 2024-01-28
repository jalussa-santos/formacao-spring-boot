package com.formacao.springbootapi.controller;

import com.formacao.springbootapi.model.medico.CadastroMedicoDto;
import com.formacao.springbootapi.model.medico.Medico;
import com.formacao.springbootapi.model.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private MedicoRepository repository;

  @PostMapping
  public void cadastrar(@RequestBody @Valid CadastroMedicoDto dados) {
    repository.save(new Medico(dados));
  }
}