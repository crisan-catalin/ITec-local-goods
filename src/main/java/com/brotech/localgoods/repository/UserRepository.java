package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);
}
