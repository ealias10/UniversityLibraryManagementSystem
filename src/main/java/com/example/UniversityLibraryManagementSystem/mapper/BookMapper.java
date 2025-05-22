package com.example.UniversityLibraryManagementSystem.mapper;

import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.modal.Books;
import com.example.UniversityLibraryManagementSystem.modal.enu.Genre;
import com.example.UniversityLibraryManagementSystem.request.BookRequest;
import com.example.UniversityLibraryManagementSystem.vo.BookVO;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Books getBook(BookRequest request, Author author)
    {
        return Books.builder().author(author).title(request.getTitle()).publisher(request.getPublisher()).isbn(request.getIsbn()).totalCopies(request.getTotalCopies()).publicationYear(request.getPublicationYear()).genre(request.getGenre()).build();
    }
    public static BookVO getBookVO(Books books)
    {
        return BookVO.builder().title(books.getTitle()).id(books.getId()).author(AuthorMapper.getAuthorVO(books.getAuthor())).isbn(books.getIsbn()).publisher(books.getPublisher()).publicationYear(books.getPublicationYear()).totalCopies(books.getTotalCopies()).genre(books.getGenre().name()).build();
    }
    public static List<BookVO> getBookList(List<Books> booksList)
    {
        return   booksList.stream().map(BookMapper::getBookVO).collect(Collectors.toList());
    }
}
