package com.kaio.SmartApp.DTO.agendamento.request;

import java.time.LocalDateTime;

import com.kaio.SmartApp.entity.Agendamento;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.entity.Agendamento.StatusAgendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {
    private int cliente_id;
    private int servico_id;
    private int horario_id;
    private String status;
    private int nota;
    private String comentario;
    private LocalDateTime data_hora_criacao;

    public Agendamento toEntity(Cliente cliente, Servicos servico, HorarioDisponivel  horario){
        return new Agendamento(
            cliente,
            servico,
            horario,
            StatusAgendamento.valueOf(getStatus()),
            getNota(),
            getComentario(),
            getData_hora_criacao()
        );
    }
}
