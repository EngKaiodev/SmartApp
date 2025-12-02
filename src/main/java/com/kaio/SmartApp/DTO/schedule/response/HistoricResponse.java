package com.kaio.SmartApp.DTO.schedule.response;

import com.kaio.SmartApp.DTO.cliente.ClienteGetResponse;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricResponse {
    private int id;
    private ProfissionalGetResponseDTO profissional;
    private ServicoResponse servico;
    private HourResponse hour;
    private int status;
    private int rate;
    private ClienteGetResponse cliente;
}
