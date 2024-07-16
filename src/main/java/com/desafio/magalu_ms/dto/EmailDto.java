package com.desafio.magalu_ms.dto;

import com.desafio.magalu_ms.enums.StatusEmail;
import com.desafio.magalu_ms.model.Email;

import java.time.LocalDateTime;

public record EmailDto(String emailAddress,
                    String subject,
                    String text,
                    LocalDateTime dateTime) {

    public Email toEmail() {
        return new Email(
                emailAddress,
                subject,
                text,
                dateTime,
                StatusEmail.ENVIADO
        );
    }
}
