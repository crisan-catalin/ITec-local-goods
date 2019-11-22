package com.brotech.localgoods.service;

import com.brotech.localgoods.model.User;

import javax.persistence.EntityNotFoundException;

import com.brotech.localgoods.repository.UserRepository;

/**
 * UserService for user operations.
 */
public interface UserService {

  /**
   * Get user by the id
   *
   * @param id the id
   * @return {@link User} entity
   */
  User getUserById(Long id) throws EntityNotFoundException;

  /**
   * Get user from DB
   *
   * @param email    user email
   * @param password user password
   * @return {@link User} entity
   */
  User getUserByEmailAndPassword(String email, String password);

  /**
   * Save user via {@link UserRepository}
   *
   * @param user entity
   * @return saved entity
   */
  User save(User user);
}
