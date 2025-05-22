package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class AutherExistException extends UniversityLibraryManagementSystemException{

    public AutherExistException(String name)
    {
        super("22", HttpStatus.CONFLICT,"Error","This name already exist pls try other name:"+name);
    }
}
