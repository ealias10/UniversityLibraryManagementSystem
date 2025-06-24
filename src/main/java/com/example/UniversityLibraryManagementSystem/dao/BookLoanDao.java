package com.example.UniversityLibraryManagementSystem.dao;

import com.example.UniversityLibraryManagementSystem.repositery.BookLoanRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookLoanDao {
    @Autowired
    private BookLoanRepositery bookLoanRepositery;

    public List<?> getBookByBookLoan()
    {
        return bookLoanRepositery.getBookLoanByActiveBook();
    }


}
