package com.formacao.springbootapi.controller;

import com.formacao.springbootapi.model.medico.CadastroMedicoDto;
import com.formacao.springbootapi.model.medico.DadosListagemMedico;
import com.formacao.springbootapi.model.medico.Medico;
import com.formacao.springbootapi.model.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
  @Transactional
  public void cadastrar(@RequestBody @Valid CadastroMedicoDto dados) {
    repository.save(new Medico(dados));
  }

  @GetMapping
  public Page<DadosListagemMedico> listar(Pageable paginacao) {
    return repository.findAll(paginacao)
        .map(DadosListagemMedico::new);
  }
}