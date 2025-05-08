package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Notificacao;
import com.kaio.SmartApp.repository.NotificacaoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    @Transactional(readOnly = true)
    public List<Notificacao> SelectAll(){
        return  notificacaoRepository.findAll();
    }

    @Transactional
    public Notificacao selectById(int id){
        return notificacaoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("sem notificações")
        );
    }
    
    @Transactional
    public Notificacao save(Notificacao notificacao){
        return notificacaoRepository.save(notificacao);
    }

    @Transactional
    public void deleteById(int id){
        notificacaoRepository.deleteById(id);
    }
}
