package com.example.UniversityLibraryManagementSystem.dao;

import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.repositery.AuthorRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestPart;

@Repository
public class AuthorDao {

    @Autowired
    private AuthorRepositery authorRepositery;

    public Author saveAuthor(Author entity)
    {
        return authorRepositery.save(entity);
    }

    public Author getAuthorByName(String name)
    {
        return authorRepositery.getAuthorByName(name);
    }
}
