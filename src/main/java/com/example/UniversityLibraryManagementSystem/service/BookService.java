package com.example.UniversityLibraryManagementSystem.service;

import com.example.UniversityLibraryManagementSystem.dao.AuthorDao;
import com.example.UniversityLibraryManagementSystem.dao.BookDao;
import com.example.UniversityLibraryManagementSystem.dao.BookLoanDao;
import com.example.UniversityLibraryManagementSystem.exception.AutherExistException;
import com.example.UniversityLibraryManagementSystem.exception.AuthorNotFountException;
import com.example.UniversityLibraryManagementSystem.exception.BooksExistException;
import com.example.UniversityLibraryManagementSystem.mapper.AuthorMapper;
import com.example.UniversityLibraryManagementSystem.mapper.BookMapper;
import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.modal.Books;
import com.example.UniversityLibraryManagementSystem.request.BookRequest;
import com.example.UniversityLibraryManagementSystem.vo.AuthorVO;
import com.example.UniversityLibraryManagementSystem.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookLoanDao bookLoanDao;
    public BookVO createBookVO(BookRequest request) throws BooksExistException, AuthorNotFountException {
        try {
            Books existBook=bookDao.getBookByIsbn(request.getIsbn());
            if(existBook!=null)
            {
                throw new BooksExistException(request.getIsbn());
            }
            Author author=authorDao.getAuthorByName(request.getAuthor());
            if(author==null)
            {
                throw new AuthorNotFountException(request.getAuthor());
            }
            Books books=BookMapper.getBook(request,author);
            Books saveBook=bookDao.createBook(books);
            log.info("Create  Books successfully, Request: {}", request);
            return BookMapper.getBookVO(saveBook);
        }
        catch (Exception e)
        {
            log.error("Error while creating Books,  Request: {}", request);
            throw e;
        }
    }

    public List<BookVO> getAllBooksByTitle(Integer limit, Integer offset,String title)
    {
        try {
            Pageable pageable = PageRequest.of(limit - 1, offset);
            List<Books> bookList=new ArrayList<>();
            if(title==null||title.trim()=="") {
                Page<Books> usersPage = bookDao.getAllBools(pageable);
                bookList.addAll(usersPage.stream().toList());
            }
            else
            {
                Page<Books> usersPage= bookDao.getAllBoolsByTitle(title,pageable);
                bookList.addAll(usersPage.stream().toList());
            }
            List<?> getList=bookLoanDao.getBookByBookLoan();
            log.info("Retrieved books list successfully");
            List<BookVO> returnList=BookMapper.getBookList(bookList);
            return BookMapper.getBookListAll(returnList,getList);
        }
        catch (Exception e)
        {
            log.error("Error while Retrieved employee list");
            throw e;
        }
    }
    public List<BookVO> getAllBooksByMemberId(Integer limit, Integer offset,String memId)
    {
        try {
            Pageable pageable = PageRequest.of(limit - 1, offset);
            List<Books> boolList=new ArrayList<>();
            if(memId == null ||memId.trim()=="")
            {
                Page<Books> usersPage = bookDao.getAllBools(pageable);
                boolList.addAll(usersPage.stream().toList());
            }
            else
            {
                Page<Books> usersPage = bookDao.getAllBooksByMemberId(memId,pageable);
                boolList.addAll(usersPage.stream().toList());
            }
            log.info("Retrieved books list successfully");
            return BookMapper.getBookList(boolList);
        }
        catch (Exception e)
        {
            log.error("Error while Retrieved employee list");
            throw e;
        }
    }
    public List<BookVO> getAllBooksByAvilabilAndGenre(boolean  isAvailable,String genre)
    {
        try {
            List<Books> getAllUsers=new ArrayList<>();
            if(isAvailable==true)
            {
                getAllUsers =bookDao.getAllBooksByAvilabilAndGenre(genre);
            }
            else {
                getAllUsers=bookDao.getAllBooksByGenre(genre);
            }
            log.info("Retrieved books list successfully");
            return BookMapper.getBookList(getAllUsers);
        }
        catch (Exception e)
        {
            log.error("Error while Retrieved employee list");
            throw e;
        }
    }

    public List<BookVO> getAllBooks(String autherName,String genre,String publicationYearFrom,String publicationYearTo)
    {
        try {
            List<Books> getAllUsers =bookDao.getAllBools(autherName,genre,publicationYearFrom,publicationYearTo);
            log.info("Retrieved books list successfully");
            return BookMapper.getBookList(getAllUsers);
        }
        catch (Exception e)
        {
            log.error("Error while Retrieved employee list");
            throw e;
        }
    }

}
