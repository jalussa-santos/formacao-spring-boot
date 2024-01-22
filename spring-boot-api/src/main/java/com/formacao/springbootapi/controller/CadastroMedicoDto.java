package com.formacao.springbootapi.controller;

public record CadastroMedicoDto(String nome, String email, String crm, Especialidade especialidade, EnderecoDto endereco) {
}