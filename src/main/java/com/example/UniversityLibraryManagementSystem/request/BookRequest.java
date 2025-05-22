package com.example.UniversityLibraryManagementSystem.request;

import com.example.UniversityLibraryManagementSystem.modal.enu.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Enumerated;
import lombok.*;

import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

   @Pattern(regexp = "[0-9]{10,13}")
    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("title")
    private String title;

    @JsonProperty("genre")
    private Genre genre;

    @JsonProperty("publication_year")
    private long publicationYear;

    @JsonProperty("publisher")
    private String publisher;


    @JsonProperty("total_copies")
    private Integer totalCopies;

    @JsonProperty("author")
    private String author;
}
