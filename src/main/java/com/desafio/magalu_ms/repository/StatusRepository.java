package com.desafio.magalu_ms.repository;

import com.desafio.magalu_ms.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
