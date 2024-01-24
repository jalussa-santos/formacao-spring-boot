package com.formacao.springbootapi.model.medico;

import com.formacao.springbootapi.model.endereco.EnderecoDto;

public record CadastroMedicoDto(String nome, String email, String crm, Especialidade especialidade, EnderecoDto endereco) {
}