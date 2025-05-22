package com.example.UniversityLibraryManagementSystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UniversityLibraryManagementSystemException extends Exception {


   private final String timeStamp;
    private final HttpStatus status;
    private final String error;
    private final String message;


    public UniversityLibraryManagementSystemException(String timeStamp,HttpStatus status,String error,String message) {
        this.timeStamp=timeStamp;
        this.status=status;
        this.error=error;
        this.message=message;
    }

}
