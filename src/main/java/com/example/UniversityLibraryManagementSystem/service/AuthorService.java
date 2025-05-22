package com.example.UniversityLibraryManagementSystem.service;

import com.example.UniversityLibraryManagementSystem.dao.AuthorDao;
import com.example.UniversityLibraryManagementSystem.exception.AutherExistException;
import com.example.UniversityLibraryManagementSystem.mapper.AuthorMapper;
import com.example.UniversityLibraryManagementSystem.modal.Author;
import com.example.UniversityLibraryManagementSystem.request.AuthorRequest;
import com.example.UniversityLibraryManagementSystem.vo.AuthorVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

      public AuthorVO createAuthor(AuthorRequest request) throws AutherExistException {
          try {
              Author existAuthor=authorDao.getAuthorByName(request.getName());
              if(existAuthor!=null)
              {
                  throw new AutherExistException(request.getName());
              }
              Author author= AuthorMapper.getAuthor(request);
              Author saveAuthor=authorDao.saveAuthor(author);
              log.info("Create  Author successfully, Request: {}", request);
              return AuthorMapper.getAuthorVO(saveAuthor);
          }
          catch (Exception e)
          {
          log.error("Error while creating Author,  Request: {}", request);
          throw e;
          }
      }
}
