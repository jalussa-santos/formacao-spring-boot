package com.formacao.springbootapi.controller;

import com.formacao.springbootapi.model.medico.CadastroMedicoDto;
import com.formacao.springbootapi.model.medico.DadosAtualizacaoMedicoDto;
import com.formacao.springbootapi.model.medico.DadosListagemMedicoDto;
import com.formacao.springbootapi.model.medico.Medico;
import com.formacao.springbootapi.model.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public Page<DadosListagemMedicoDto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
    return repository.findAllByAtivoTrue(paginacao)
        .map(DadosListagemMedicoDto::new);
  }

  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDto dados) {

    var medico = repository.getReferenceById(dados.id());
    medico.atualizarInformacoes(dados);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void excluir(@PathVariable Long id) {

    var medico = repository.getReferenceById(id);
    medico.excluir();
  }
}