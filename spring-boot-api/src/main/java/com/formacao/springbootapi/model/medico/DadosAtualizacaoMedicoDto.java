package com.formacao.springbootapi.model.medico;

import com.formacao.springbootapi.model.endereco.EnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicoDto(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDto endereco) {

}