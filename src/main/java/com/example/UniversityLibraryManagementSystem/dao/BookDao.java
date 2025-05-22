package com.example.UniversityLibraryManagementSystem.dao;

import com.example.UniversityLibraryManagementSystem.modal.Books;
import com.example.UniversityLibraryManagementSystem.repositery.BookRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    private BookRepositery bookRepositery;

    public Books createBook(Books entity)
    {
        return bookRepositery.save(entity);
    }
    public Books getBookByIsbn(String isbn)
    {
        return bookRepositery.getBookByIsbn(isbn);
    }

    public Page<Books> getAllBoolsByTitle(String title,Pageable pageable)
    {
        return bookRepositery.getAllBooksByTitle(title,pageable);
    }

    public List<Books> getAllBools(String autherName, String genre, String publicationYearFrom, String publicationYearTo)
    {
        return bookRepositery.getAllbook(autherName,genre,publicationYearFrom,publicationYearTo);

    }
    public Page<Books> getAllBooksByMemberId(String memId,Pageable pageable)
    {
        return bookRepositery.getAllBooksByMemberId(memId,pageable);
    }
    public List<Books> getAllBooksByAvilabilAndGenre(String avilabil,String genre)
    {
        return bookRepositery.getAllBooksByAvilabilAndGenre(avilabil,genre);
    }


}
