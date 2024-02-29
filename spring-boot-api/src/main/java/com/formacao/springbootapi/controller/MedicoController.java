package com.formacao.springbootapi.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.formacao.springbootapi.model.medico.CadastroMedicoDto;
import com.formacao.springbootapi.model.medico.DadosListagemMedicoDto;
import com.formacao.springbootapi.model.medico.DadosMedicoRequestDto;
import com.formacao.springbootapi.model.medico.DadosMedicoResponseDto;
import com.formacao.springbootapi.model.medico.Medico;
import com.formacao.springbootapi.model.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private MedicoRepository repository;

  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid CadastroMedicoDto dados,
      UriComponentsBuilder uriBuilder) {

    var medico = new Medico(dados);
    repository.save(medico);

    var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

    return created(uri).body(new DadosMedicoResponseDto(medico));
  }

  @GetMapping
  public ResponseEntity<Page<DadosListagemMedicoDto>> listar(
      @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
    var page = repository.findAllByAtivoTrue(paginacao)
        .map(DadosListagemMedicoDto::new);

    return ok(page);
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid DadosMedicoRequestDto dados) {

    var medico = repository.getReferenceById(dados.id());
    medico.atualizarInformacoes(dados);

    return ok(new DadosMedicoResponseDto(medico));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id) {

    var medico = repository.getReferenceById(id);
    medico.excluir();

    return noContent().build();
  }
}