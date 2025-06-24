package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends  UniversityLibraryManagementSystemException{

    public ExpiredTokenException()
    {
        super("", HttpStatus.NOT_FOUND,"Error","Token Expire");
    }
}
