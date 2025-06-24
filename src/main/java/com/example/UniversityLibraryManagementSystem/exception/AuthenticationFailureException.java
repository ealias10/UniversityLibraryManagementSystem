package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationFailureException extends UniversityLibraryManagementSystemException{
    public AuthenticationFailureException()
    {
      super("", HttpStatus.UNAUTHORIZED,"Error","UnAuthor");
    }
}
