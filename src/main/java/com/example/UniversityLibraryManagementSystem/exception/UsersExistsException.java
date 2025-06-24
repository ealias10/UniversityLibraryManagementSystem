package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class UsersExistsException extends UniversityLibraryManagementSystemException{
    public UsersExistsException(String name)
    {
        super("", HttpStatus.CONFLICT,"Error","This user Already Exist name"+name);
    }
}
