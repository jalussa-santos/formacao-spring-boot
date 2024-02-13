package com.formacao.springbootapi.model.medico;

import com.formacao.springbootapi.model.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String crm;
  private String telefone;
  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;
  @Embedded
  private Endereco endereco;
  public Medico(CadastroMedicoDto medico) {
    this.nome = medico.nome();
    this.email = medico.email();
    this.crm = medico.crm();
    this.telefone = medico.telefone();
    this.especialidade = medico.especialidade();
    this.endereco = new Endereco(medico.endereco());
  }

  public void atualizarInformacoes(DadosAtualizacaoMedicoDto dados) {

      if (dados.nome() != null) {
        this.nome = dados.nome();
      }
      if (dados.telefone() != null) {
        this.telefone = dados.telefone();
      }
      if (dados.endereco() != null) {
        this.endereco.atualizarInformacoes(dados.endereco());
      }
  }
}