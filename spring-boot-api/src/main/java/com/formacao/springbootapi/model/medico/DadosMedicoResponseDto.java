package com.formacao.springbootapi.model.medico;

import com.formacao.springbootapi.model.endereco.Endereco;

public record DadosMedicoResponseDto(Long id, String nome, String email, String crm,
                                     String telefone, Especialidade especialidade,
                                     Endereco endereco) {

  public DadosMedicoResponseDto(Medico medico) {
    this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
        medico.getEspecialidade(), medico.getEndereco());

  }
}