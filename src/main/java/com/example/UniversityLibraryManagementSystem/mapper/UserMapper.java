package com.example.UniversityLibraryManagementSystem.mapper;


import com.example.UniversityLibraryManagementSystem.modal.Role;
import com.example.UniversityLibraryManagementSystem.modal.Users;
import com.example.UniversityLibraryManagementSystem.request.UserCreateRequest;
import com.example.UniversityLibraryManagementSystem.vo.LoginVO;
import com.example.UniversityLibraryManagementSystem.vo.UsersVO;

public class UserMapper {
  public static Users createUser(UserCreateRequest request, Role role) {
    return Users.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .role(role)
            .email(request.getEmail())
            .active(true)
            .build();
  }

  public static UsersVO createUserVO(Users user) {
    return UsersVO.builder()
        .userId(user.getId())
        .userName(user.getUsername())
        .userRole(user.getRole().getName())
        .email(user.getEmail())
        .build();
  }

  public static LoginVO createLoginVO(String accessToken) {
    return LoginVO.builder().accessToken(accessToken).build();
  }
}
