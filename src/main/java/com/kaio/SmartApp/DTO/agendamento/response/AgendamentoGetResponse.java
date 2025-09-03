package com.kaio.SmartApp.DTO.agendamento.response;

import java.time.LocalDateTime;

import com.kaio.SmartApp.DTO.cliente.response.ClienteGetResponse;
import com.kaio.SmartApp.DTO.horario_disponivel.response.HorarioDisponivelGetResponseDTO;
import com.kaio.SmartApp.entity.Servicos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoGetResponse {
    private int id;
    private ClienteGetResponse cliente;
    private Servicos servico;
    private HorarioDisponivelGetResponseDTO horario;
    private String status;
    private int nota;
    private String comentario;
    private LocalDateTime data_hora_criacao;
}
