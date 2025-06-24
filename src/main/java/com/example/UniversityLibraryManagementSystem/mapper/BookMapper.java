package com.example.UniversityLibraryManagementSystem.mapper;

import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.modal.Books;
import com.example.UniversityLibraryManagementSystem.request.BookRequest;
import com.example.UniversityLibraryManagementSystem.vo.BookVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static Books getBook(BookRequest request, Author author)
    {
        return Books.builder().author(author).title(request.getTitle()).publisher(request.getPublisher()).isbn(request.getIsbn()).totalCopies(request.getTotalCopies()).publicationYear(request.getPublicationYear()).genre(request.getGenre()).build();
    }
    public static BookVO getBookVO(Books books)
    {
        return BookVO.builder().title(books.getTitle()).id(books.getId()).author(AuthorMapper.getAuthorVO(books.getAuthor())).isbn(books.getIsbn()).publisher(books.getPublisher()).publicationYear(books.getPublicationYear()).totalCopies(books.getTotalCopies()).genre(books.getGenre().name()).avilabileCopies(books.getTotalCopies()).build();
    }
    public static List<BookVO> getAvilabileCopyBooks(List<BookVO> bookVOList)
    {
        return null;
    }
    public static List<BookVO> getBookList(List<Books> booksList)
    {
        return   booksList.stream().map(BookMapper::getBookVO).collect(Collectors.toList());
    }
    public static List<BookVO> getBookListAll(List<BookVO> booksList, List<?> list)
    {
            Iterator itr=list.iterator();
            while(itr.hasNext()) {
                Object a[] = (Object[]) itr.next();
                String value = (String) a[1];
                long key = (long) a[0];
                for (BookVO obj : booksList) {
                    if (obj.getTitle().equals(value)) {
                        obj.setAvilabileCopies(obj.getTotalCopies()-key);
                    }
                }
            }

        return booksList;
    }
}
