package com.example.UniversityLibraryManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class BooksExistException extends UniversityLibraryManagementSystemException{

    public BooksExistException(String isbn) {

        super("22", HttpStatus.CONFLICT, "Error", "This isbn already exist pls try other name:" + isbn);

    }
}
