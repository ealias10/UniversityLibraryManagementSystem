package com.example.UniversityLibraryManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortVO {

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("property")
    private String property;

    public SortVO()
    {
        this.direction="DESC";
        this.direction="publicationYear";
    }



}
