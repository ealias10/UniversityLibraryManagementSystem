package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class AuthorNotFountException extends UniversityLibraryManagementSystemException{

    public AuthorNotFountException(String name)
    {

        super("22", HttpStatus.NOT_FOUND,"Error","This name not fount pls try other name:"+name);

    }
}
