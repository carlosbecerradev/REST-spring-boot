package com.example.signup.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.signup.entity.User;

public interface IUserRepository extends CrudRepository<User, Long> {

}
