package com.desafio.magalu_ms.repository;

import com.desafio.magalu_ms.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
