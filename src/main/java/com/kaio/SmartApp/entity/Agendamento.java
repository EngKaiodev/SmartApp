package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.kaio.SmartApp.DTO.agendamento.response.AgendamentoGetResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Agendamentos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agendamento implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_agendamento;
  @ManyToOne
  @JoinColumn(name = "id_cliente", nullable = false)
  private Cliente cliente;
  @ManyToOne
  @JoinColumn(name = "id_servico", nullable = false)
  private Servico servico;
  @Column(nullable = false, unique = false, length = 50)
  private LocalDateTime data_hora;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, unique = true, length = 50)
  private StatusAgendamento status;
  @Column(nullable = false, unique = true, length = 50)
  private int nota;
  @Column(nullable = false, unique = true, length = 50)
  private String comentario;
  @Column(nullable = false, unique = false, length = 50)
  private LocalDateTime data_hora_criacao;

  public enum StatusAgendamento {
    PENDENTE, CONFIRMADO, CANCELADO, REAGENDADO
  }

  public Agendamento(Cliente cliente, Servico servico, LocalDateTime data_hora, StatusAgendamento status, int nota,
      String comentario, LocalDateTime data_hora_criacao) {
    this.cliente = cliente;
    this.servico = servico;
    this.data_hora = data_hora;
    this.status = status;
    this.nota = nota;
    this.comentario = comentario;
    this.data_hora_criacao = data_hora_criacao;
  }

  public AgendamentoGetResponse toGetResponse(){
    return new AgendamentoGetResponse(
      getId_agendamento(),
      getCliente().toGetResponse(),
      getServico().toGetDTO(),
      getData_hora(),
      getStatus().toString(),
      getNota(),
      getComentario(),
      getData_hora_criacao()
    );
   }
}
