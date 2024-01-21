package com.formacao.springbootapi.controller;

import java.util.Objects;

public final class TelefoneDto {

  private final String ddd;
  private final String numero;

  public TelefoneDto(String ddd, String numero) {
    this.ddd = ddd;
    this.numero = numero;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ddd, numero);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof TelefoneDto)) {
      return false;
    } else {
      TelefoneDto other = (TelefoneDto) obj;
      return Objects.equals(ddd, other.ddd)
          && Objects.equals(numero, other.numero);
    }
  }

  public String getDdd() {
    return this.ddd;
  }

  public String getNumero() {
    return this.numero;
  }
}
