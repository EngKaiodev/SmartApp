package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.agendamento.request.AgendamentoRequestDTO;
import com.kaio.SmartApp.DTO.agendamento.response.AgendamentoGetResponse;
import com.kaio.SmartApp.entity.Agendamento;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.entity.Servico;
import com.kaio.SmartApp.repository.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteService clienteService;
    private final ServicoService servicoService;
    private final HorarioDisponivelService horarioDisponivelService;

    @Transactional(readOnly = true)
    public List<Agendamento> SelectAll() {
        return agendamentoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Agendamento selectById(int id) {
        return agendamentoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Agendamento não encontrado"));
    }

    @Transactional
    public AgendamentoGetResponse save(AgendamentoRequestDTO agendamento) {
        Cliente cliente = clienteService.selectEntityById(agendamento.getCliente_id());
        Servico servico = servicoService.selectEntityById(agendamento.getServico_id());
        HorarioDisponivel horario = horarioDisponivelService.selectEntityByID(agendamento.getHorario_id());
        Agendamento response = agendamentoRepository.save(agendamento.toEntity(cliente, servico, horario));
        return response.toGetResponse();
    }

    @Transactional
    public void deleteById(int id) {
        agendamentoRepository.deleteById(id);
    }
}
