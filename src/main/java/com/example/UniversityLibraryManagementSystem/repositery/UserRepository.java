package com.example.UniversityLibraryManagementSystem.repositery;


import com.example.UniversityLibraryManagementSystem.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

  @Query("select u from Users u where u.username=:name and u.active=true")
  Users getUserByName(@Param("name") String name);
}
