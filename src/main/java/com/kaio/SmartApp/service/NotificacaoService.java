package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaio.SmartApp.entity.Notificacao;
import com.kaio.SmartApp.repository.NotificacaoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    @Transactional(readOnly = true)
    public List<Notificacao> SelectAll(){
        return  notificacaoRepository.findAll();
    }

}
