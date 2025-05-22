package com.example.UniversityLibraryManagementSystem.repositery;

import com.example.UniversityLibraryManagementSystem.modal.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepositery extends JpaRepository<Books, UUID> {

    @Query("select b from Books b where b.isbn=:isbn")
    Books getBookByIsbn(@Param("isbn")String isbn);

    @Query("select b from Books b where b.title=:title ORDER BY b.title ASC")
    Page<Books> getAllBooksByTitle(@Param("title")String title,Pageable pageable);

    @Query("select b from Books b inner join Author a on (b.author.id=a.id)   where a.name=:authorName and b.genre=:genre and b.publicationYear BETWEEN :pf and :pt  ORDER BY b.publicationYear ASC")
    List<Books> getAllbook(@Param("authorName") String autherName,@Param("genre") String genre,@Param("pf") String publicationYearFrom,@Param("pt") String publicationYearTo);

    @Query("select b from Books b inner join BookLoan l on(l.book.id=b.id) inner join LibraryMember lm on(lm.id=l.member.id) where lm. memberId=:memid ")
    Page<Books> getAllBooksByMemberId(@Param("memId")String memId,Pageable pageable);

    @Query("select b from Books b where b.genre=:genre ORDER BY b.title ASC")
    List<Books> getAllBooksByAvilabilAndGenre(String avl,String genre);



}
