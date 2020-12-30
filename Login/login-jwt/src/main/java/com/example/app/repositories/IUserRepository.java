package com.example.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entities.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
