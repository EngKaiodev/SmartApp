package com.kaio.SmartApp.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FcmService {
    private final UserRepository userRepository;

    public void enviarNotificacao(int destinyId, String titulo, String corpo) {
        UserModel user = userRepository.findById(destinyId).orElseThrow(
                () -> new EntityNotFoundException("Usuário com id " + destinyId + " não encontrado."));

        if (user.getTokenFCM() == null || user.getTokenFCM().isEmpty()) {
            throw new EntityNotFoundException("Usuário com id " + destinyId + "não tem token cadastrado.");
        }

        try {
            Notification notification = Notification.builder()
                    .setTitle(titulo)
                    .setBody(corpo)
                    .build();

            Message message = Message.builder()
                    .setToken(user.getTokenFCM())
                    .setNotification(notification)
                    // .putData("idAgendamento", "123") // Dados extras opcionais
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Mensagem enviada com sucesso: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
