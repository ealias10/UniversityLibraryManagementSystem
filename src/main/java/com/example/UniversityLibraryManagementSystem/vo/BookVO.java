package com.example.UniversityLibraryManagementSystem.vo;

import com.example.UniversityLibraryManagementSystem.modal.enu.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookVO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("title")
    private String title;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("publication_year")
    private long publicationYear;

    @JsonProperty("publisher")
    private String publisher;


    @JsonProperty("total_copies")
    private Integer totalCopies;

    @JsonProperty("author")
    private AuthorVO author;

}
