package com.desafio.magalu_ms.dto;

import com.desafio.magalu_ms.model.Channel;
import com.desafio.magalu_ms.model.Notification;
import com.desafio.magalu_ms.model.Status;

import java.time.LocalDateTime;

public record NotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
