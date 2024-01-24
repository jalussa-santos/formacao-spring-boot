package com.formacao.springbootapi.model.endereco;

public record EnderecoDto(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
}