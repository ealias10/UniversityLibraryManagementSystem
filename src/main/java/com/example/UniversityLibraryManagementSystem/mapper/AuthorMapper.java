package com.example.UniversityLibraryManagementSystem.mapper;

import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.request.AuthorRequest;
import com.example.UniversityLibraryManagementSystem.vo.AuthorVO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthorMapper {

    public static Author getAuthor(AuthorRequest request)
    {
        return Author.builder().biography(request.getBiography()).name(request.getName()).birthDate(System.currentTimeMillis()).build();
    }
    public static AuthorVO getAuthorVO(Author author)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String formattedTime = sdf.format(new Date(author.getBirthDate()));
        return AuthorVO.builder().biography(author.getBiography()).id(author.getId()).birthDate(formattedTime).name(author.getName()).build();
    }
}
