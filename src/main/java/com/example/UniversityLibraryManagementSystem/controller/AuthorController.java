package com.example.UniversityLibraryManagementSystem.controller;

import com.example.UniversityLibraryManagementSystem.exception.AutherExistException;
import com.example.UniversityLibraryManagementSystem.request.AuthorRequest;
import com.example.UniversityLibraryManagementSystem.service.AuthorService;
import com.example.UniversityLibraryManagementSystem.vo.AuthorVO;
import com.example.UniversityLibraryManagementSystem.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<ResponseVO<Object>> createAuthor(@RequestBody(required = true)AuthorRequest request) throws AutherExistException {
        ResponseVO responseVO=new ResponseVO<>();
        AuthorVO authorVO=authorService.createAuthor(request);
        responseVO.addData(authorVO);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

}
