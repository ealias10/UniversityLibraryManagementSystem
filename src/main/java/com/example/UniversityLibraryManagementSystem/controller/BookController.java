package com.example.UniversityLibraryManagementSystem.controller;

import com.example.UniversityLibraryManagementSystem.exception.AutherExistException;
import com.example.UniversityLibraryManagementSystem.exception.AuthorNotFountException;
import com.example.UniversityLibraryManagementSystem.exception.BooksExistException;
import com.example.UniversityLibraryManagementSystem.modal.Books;
import com.example.UniversityLibraryManagementSystem.request.AuthorRequest;
import com.example.UniversityLibraryManagementSystem.request.BookRequest;
import com.example.UniversityLibraryManagementSystem.service.BookService;
import com.example.UniversityLibraryManagementSystem.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<ResponseVO<Object>> createBook(@RequestBody(required = true) BookRequest request) throws BooksExistException, AuthorNotFountException {
        ResponseVO responseVO=new ResponseVO<>();
        BookVO bookVO=bookService.createBookVO(request);
        responseVO.addData(bookVO);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseVO <Object>> getAllBooksByTitle(@RequestParam("title")String  title,@RequestParam("limit")Integer limit,@RequestParam("offset")Integer offset)
    {
        ResponseVO responseVO=new ResponseVO<>();
        List<BookVO> list=bookService.getAllBooksByTitle(limit,offset,title);
        PaginatedResponseVOAndCount page= PaginatedResponseVOAndCount.builder().sort(new SortVO()).pageNumber(list.size()).number(limit).pageSize(list.size()).totalElement(list.size()).last(list.isEmpty()).fist(list.isEmpty()).numberOfElement(list.size()).empty(list.isEmpty()).build();
        responseVO.setPageable(page);
        responseVO.addDataList(list);
        return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }

    @GetMapping("/search2")
    public ResponseEntity<ResponseVO <Object>> getAllBooksByMemberId(@RequestParam("loanedByMemberId")String  loanedByMemberId,@RequestParam("limit")Integer limit,@RequestParam("offset")Integer offset)
    {
        ResponseVO responseVO=new ResponseVO<>();
        List<BookVO> list=bookService.getAllBooksByTitle(limit,offset,loanedByMemberId);
        PaginatedResponseVOAndCount page= PaginatedResponseVOAndCount.builder().sort(new SortVO()).pageNumber(list.size()).number(limit).pageSize(list.size()).totalElement(list.size()).last(list.isEmpty()).fist(list.isEmpty()).numberOfElement(list.size()).empty(list.isEmpty()).build();
        responseVO.setPageable(page);
        responseVO.addDataList(list);
        return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }
    @GetMapping("/search1")
    public ResponseEntity<ResponseVO <Object>> getAllBooks(@RequestParam("authorName")String  autherName,@RequestParam("genre")String genre,@RequestParam("publicationYearFrom")String publicationYearFrom,@RequestParam("publicationYearTo")String publicationYearTo)
    {
        ResponseVO responseVO=new ResponseVO<>();
        List<BookVO> list=bookService.getAllBooks(autherName,genre,publicationYearFrom,publicationYearTo);
        responseVO.addDataList(list);
        return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }
    @GetMapping("/search3")
    public ResponseEntity<ResponseVO <Object>> getAllBooksByAvilabilAndGenre(@RequestParam("isAvailable")String  isAvailable,@RequestParam("genre")String genre)
    {
        ResponseVO responseVO=new ResponseVO<>();
        List<BookVO> list=bookService. getAllBooksByAvilabilAndGenre(isAvailable,genre);
        responseVO.addDataList(list);
        return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }
}
