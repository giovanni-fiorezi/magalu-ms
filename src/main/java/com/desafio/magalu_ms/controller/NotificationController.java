package com.desafio.magalu_ms.controller;

import com.desafio.magalu_ms.dto.NotificationDto;
import com.desafio.magalu_ms.model.Notification;
import com.desafio.magalu_ms.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> scheduledNotification(@RequestBody NotificationDto dto) {
        service.scheduledNotification(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> findByIdNotification(@PathVariable("notificationId") Long notificationId) {
        Optional<Notification> notification = service.findById(notificationId);
        return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId) {
        service.cancelNotification(notificationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
