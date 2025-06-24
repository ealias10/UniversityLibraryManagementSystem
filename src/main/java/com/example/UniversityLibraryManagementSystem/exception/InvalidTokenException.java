package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends UniversityLibraryManagementSystemException{
    public InvalidTokenException()
    {
        super("", HttpStatus.NOT_FOUND,"Error","token invalude");
    }
}
