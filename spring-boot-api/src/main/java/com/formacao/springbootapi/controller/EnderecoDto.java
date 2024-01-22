package com.formacao.springbootapi.controller;

public record EnderecoDto(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
}