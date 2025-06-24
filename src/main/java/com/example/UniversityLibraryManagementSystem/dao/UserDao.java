package com.example.UniversityLibraryManagementSystem.dao;


import com.example.UniversityLibraryManagementSystem.modal.Users;
import com.example.UniversityLibraryManagementSystem.repositery.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public class UserDao {
  @Autowired
  private UserRepository userRepository;

  public Users getUserByName(String name) {
    return userRepository.getUserByName(name);
  }

  public Users getUserById(UUID id) {
    return userRepository.getReferenceById(id);
  }

  public Users saveUser(Users user) {
    return userRepository.save(user);
  }
}
