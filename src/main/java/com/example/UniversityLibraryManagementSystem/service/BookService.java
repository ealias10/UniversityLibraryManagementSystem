package com.example.UniversityLibraryManagementSystem.service;

import com.example.UniversityLibraryManagementSystem.dao.AuthorDao;
import com.example.UniversityLibraryManagementSystem.dao.BookDao;
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

import java.util.List;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;
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
            Page<Books> usersPage = bookDao.getAllBoolsByTitle(title,pageable);
            List<Books> getAllUsers = usersPage.toList();
            log.info("Retrieved books list successfully");
            return BookMapper.getBookList(getAllUsers);
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
            Page<Books> usersPage = bookDao.getAllBooksByMemberId(memId,pageable);
            List<Books> getAllUsers = usersPage.toList();
            log.info("Retrieved books list successfully");
            return BookMapper.getBookList(getAllUsers);
        }
        catch (Exception e)
        {
            log.error("Error while Retrieved employee list");
            throw e;
        }
    }
    public List<BookVO> getAllBooksByAvilabilAndGenre(String  isAvailable,String genre)
    {
        try {
            List<Books> getAllUsers =bookDao.getAllBooksByAvilabilAndGenre(isAvailable,genre);
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
