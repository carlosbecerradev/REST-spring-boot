package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.EmailConfirmationToken;

@Repository
public interface IEmailConfirmationTokenRepository extends CrudRepository<EmailConfirmationToken, Long> {
	Optional<EmailConfirmationToken> findByToken(String token);
}
