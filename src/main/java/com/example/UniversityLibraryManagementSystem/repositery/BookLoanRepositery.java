package com.example.UniversityLibraryManagementSystem.repositery;

import com.example.UniversityLibraryManagementSystem.modal.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.UUID;

public interface BookLoanRepositery extends JpaRepository<BookLoan, UUID> {

    @Query("select count(bl.book.id),bl.book.title from BookLoan bl group by bl.book.title order by bl.book.title ASC")
    List<?> getBookLoanByActiveBook();

}
