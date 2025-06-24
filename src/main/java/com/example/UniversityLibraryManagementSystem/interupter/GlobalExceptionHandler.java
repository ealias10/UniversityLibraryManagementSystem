package com.example.UniversityLibraryManagementSystem.interupter;


import com.example.UniversityLibraryManagementSystem.exception.UniversityLibraryManagementSystemException;
import com.example.UniversityLibraryManagementSystem.vo.ResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    long currentTimeMillis = System.currentTimeMillis();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // Customize the format as needed
    String formattedTime = sdf.format(new Date(currentTimeMillis));
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseVO<Object>> handles(
            HttpServletRequest request, MissingServletRequestParameterException exception) {
        StringBuilder validationErrors=new StringBuilder();
        validationErrors.append(exception.getParameterName()).append(exception.getMessage());
        String error=String.valueOf(validationErrors);
        ResponseVO<Object> response = new ResponseVO<>();
        response.setMessage(error);
        response.setPath(request.getRequestURI());
        response.setTimeStamp(formattedTime);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseVO<Object>> handles(
            HttpServletRequest request, DataIntegrityViolationException exception) {
        StringBuilder validationErrors=new StringBuilder();
        validationErrors.append(exception.getMessage());
        String error=String.valueOf(validationErrors);
        ResponseVO<Object> response = new ResponseVO<>();
        response.setMessage(error);
        response.setPath(request.getRequestURI());
        response.setTimeStamp(formattedTime);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UniversityLibraryManagementSystemException.class)
    public ResponseEntity<ResponseVO<Object>> handle(
            HttpServletRequest request,UniversityLibraryManagementSystemException exception) {
        logError(request, exception);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setStatus(exception.getStatus().value());
        responseVO.setTimeStamp(formattedTime);
        responseVO.setError(exception.getError());
        responseVO.setMessage(exception.getMessage());
        responseVO.setPath(request.getRequestURI());
        responseVO.setError(responseVO.getMessage());
        return new ResponseEntity<>(responseVO, exception.getStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseVO<Object>> handle(
            HttpServletRequest request,Exception exception) {
        logError(request, exception);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setStatus(500);
        responseVO.setTimeStamp(formattedTime);
        responseVO.setMessage(exception.getMessage());
        responseVO.setPath(request.getRequestURI());
        responseVO.setError(responseVO.getMessage());
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseVO<Object>> handle(
            HttpServletRequest request, MethodArgumentNotValidException exception) {
        StringBuilder validationErrors=new StringBuilder();
        for (FieldError fieldError : exception.getFieldErrors()) {
            if (fieldError.getDefaultMessage() != null) {
                validationErrors.append(fieldError.getField()).append(fieldError.getDefaultMessage());
            }
        }
        String error=String.valueOf(validationErrors);
        ResponseVO<Object> response = new ResponseVO<>();
        response.setMessage(error);
        response.setPath(request.getRequestURI());
        response.setError(response.getMessage());
        response.setTimeStamp(formattedTime);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseVO<Object>>  handleAccessDeniedException(AccessDeniedException ex,HttpServletRequest request) {
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setStatus(403);
        responseVO.setTimeStamp(formattedTime);
        responseVO.setMessage(ex.getMessage());
        responseVO.setPath(request.getRequestURI());
        responseVO.setError("Access Denied: You do not have permission to access this resource.");
        return new ResponseEntity<>(responseVO, HttpStatus.FORBIDDEN);
    }

    public static byte[] getUnauthorizedResponseForAuthFilterErrors(Exception exception,HttpServletRequest request,HttpServletResponse response) {

        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setStatus(response.getStatus());
       // responseVO.setPath(request.getRequestURI());
        if(response.getStatus()==403)
        responseVO.setMessage(HttpStatus.FORBIDDEN.getReasonPhrase());
        else
        responseVO.setMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase());
      //  responseVO.setPath(response.getContentType());
        responseVO.setError(responseVO.getMessage());
        String responseString = convertToJsonString(responseVO);
        return responseString.getBytes();
    }
    private static String convertToJsonString(ResponseVO<Object> response) {
        String responseString = null;
        try {
            responseString = OBJECT_MAPPER.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            responseString = response.toString();
        }
        return responseString;
    }
    private void logError(HttpServletRequest request, Exception exception) {

        log.error("Failed {} {} {}", request.getMethod(), request.getRequestURI(), exception);
    }
}
