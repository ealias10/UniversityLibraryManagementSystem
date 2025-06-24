package com.example.UniversityLibraryManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginVO {

  @JsonProperty(value = "access_token")
  private String accessToken;

}
