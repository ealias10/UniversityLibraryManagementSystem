package com.example.UniversityLibraryManagementSystem.repositery;

import com.example.UniversityLibraryManagementSystem.modal.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AuthorRepositery extends JpaRepository<Author, UUID> {

    @Query("select a from Author a where a.name=:name")
    Author getAuthorByName(@Param("name")String name);
}
