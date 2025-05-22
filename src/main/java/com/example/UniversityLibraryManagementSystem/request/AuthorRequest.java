package com.example.UniversityLibraryManagementSystem.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class AuthorRequest {

    @JsonProperty("name")
    private String name;


    @JsonProperty("biography")
    private String biography;

}
