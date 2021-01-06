package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.User;

@Repository
public interface IUserRespository extends CrudRepository<User, Long> {
	boolean existsByEmail(String email);
}
