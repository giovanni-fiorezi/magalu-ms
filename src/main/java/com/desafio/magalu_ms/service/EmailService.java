package com.desafio.magalu_ms.service;

import com.desafio.magalu_ms.enums.StatusEmail;
import com.desafio.magalu_ms.model.Email;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private static final String REGEX_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail() {
        Email email = new Email();
        try {
            email.setEmail("giovannifgiovanelli@gmail.com");
            email.setSubject("Notificação Magalu");
            email.setText("Reveja sua notificação para não haver mais erros");
            email.setDateTime(LocalDateTime.now());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("noreply@email.com");
            message.setTo(email.getEmail());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            validarEmail(email);

            mailSender.send(message);

            email.setStatusEMail(StatusEmail.ENVIADO);
        } catch (MailException e) {
            email.setStatusEMail(StatusEmail.ERRO);
        }

    }

    private void validarEmail(Email email) {
        String emailAddress = email.getEmail();
        boolean emailFormat = emailAddress.matches(REGEX_EMAIL);
        if(!emailFormat) {
            throw new RuntimeException("Formato do e-mail inválido, corrija!");
        }
    }
}
