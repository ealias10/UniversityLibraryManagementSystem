package com.example.UniversityLibraryManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorVO {

    @JsonProperty("id")
    private UUID id;


    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("name")
    private String name;


    @JsonProperty("biography")
    private String biography;
}
