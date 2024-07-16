package com.desafio.magalu_ms.service;

import com.desafio.magalu_ms.dto.NotificationDto;
import com.desafio.magalu_ms.model.Notification;
import com.desafio.magalu_ms.model.Status;
import com.desafio.magalu_ms.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduledNotification(NotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if(!notification.isPresent()) {
           throw new RuntimeException(String.format("O id: %d não foi encontrado", notificationId));
        } else {
            return notification;
        }
    }

    public void cancelNotification(Long notificationId) {
        Optional<Notification> notification = findById(notificationId);
        if(notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        } else {
            throw new RuntimeException(String.format("O id: %d não existe!", notificationId));
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        List<Notification> notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.ERROR.toStatus(), Status.Values.PENDING.toStatus()),
                dateTime
        );
        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            //TODO - Realizar o envio da notificação

            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }
}
