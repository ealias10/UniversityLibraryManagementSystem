package com.example.UniversityLibraryManagementSystem.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginRequest {

  @NotNull()
  @JsonProperty("username")
  private String username;

  @NotNull()
  @JsonProperty("password")
  private String password;
}
