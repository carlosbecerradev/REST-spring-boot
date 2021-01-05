package com.example.signup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.signup.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	boolean existsByUsername(String usernameString);
}
