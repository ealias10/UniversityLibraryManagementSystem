package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends UniversityLibraryManagementSystemException{
    public  RoleNotFoundException(String name)
    {
        super("", HttpStatus.NOT_FOUND,"error","this role not fount role :"+name);
    }
}
