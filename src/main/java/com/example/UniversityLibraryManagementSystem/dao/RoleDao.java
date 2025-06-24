package com.example.UniversityLibraryManagementSystem.dao;


import com.example.UniversityLibraryManagementSystem.modal.Role;
import com.example.UniversityLibraryManagementSystem.repositery.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class RoleDao {
  @Autowired
  private
  RoleRepository roleRepository;

  public Role getRoleByName(String role) {
    return roleRepository.getRoleByName(role);
  }
}
