package com.desafio.magalu_ms.model;

import com.desafio.magalu_ms.enums.StatusEmail;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String subject;
    private String text;
    private LocalDateTime dateTime;
    private StatusEmail statusEMail;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id")
    private Notification notification;

    public Email() {
    }

    public Email(String email, String subject, String text, LocalDateTime dateTime, StatusEmail statusEMail) {
        this.email = email;
        this.subject = subject;
        this.text = text;
        this.dateTime = dateTime;
        this.statusEMail = statusEMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public StatusEmail getStatusEMail() {
        return statusEMail;
    }

    public void setStatusEMail(StatusEmail statusEMail) {
        this.statusEMail = statusEMail;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
