package com.kaio.SmartApp.DTO.agendamento.request;

import java.time.LocalDateTime;

import com.kaio.SmartApp.entity.Agendamento.StatusAgendamento;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.entity.Servico;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {
    private int cliente_id;
    private int servico_id;
    private LocalDateTime data_hora;
    private String status;
    private int nota;
    private String comentario;
    private LocalDateTime data_hora_criacao;
}
