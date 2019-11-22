package com.brotech.localgoods.service.impl;

import com.brotech.localgoods.model.User;
import com.brotech.localgoods.repository.UserRepository;
import com.brotech.localgoods.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultUserService implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getUserById(Long id) throws EntityNotFoundException {
    return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public User getUserByEmailAndPassword(String email, String password) {
    return userRepository.findUserByEmailAndPassword(email, password);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
}
