package com.pm.pacient_service;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class PacientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacientServiceApplication.class, args);
	}

}
