package com.example.UniversityLibraryManagementSystem.controller;


import com.example.UniversityLibraryManagementSystem.exception.AuthenticationFailureException;
import com.example.UniversityLibraryManagementSystem.exception.RoleNotFoundException;
import com.example.UniversityLibraryManagementSystem.exception.UsersExistsException;
import com.example.UniversityLibraryManagementSystem.request.LoginRequest;
import com.example.UniversityLibraryManagementSystem.request.UserCreateRequest;
import com.example.UniversityLibraryManagementSystem.service.UserService;
import com.example.UniversityLibraryManagementSystem.vo.LoginVO;
import com.example.UniversityLibraryManagementSystem.vo.ResponseVO;
import com.example.UniversityLibraryManagementSystem.vo.UsersVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@Validated
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  public ResponseEntity<ResponseVO<Object>> createUser(
      @RequestBody(required = true) UserCreateRequest request)
      throws RoleNotFoundException, UsersExistsException {
    ResponseVO<Object> response = new ResponseVO<>();
    UsersVO usersVO = userService.createUser(request);
    response.addData(usersVO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<ResponseVO<Object>> loginUser(
      @RequestBody(required = true) LoginRequest loginRequest)
      throws AuthenticationFailureException {
    ResponseVO<Object> response = new ResponseVO<>();
    LoginVO loginVO = userService.loginUser(loginRequest);
    response.addData(loginVO);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
