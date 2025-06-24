package com.example.UniversityLibraryManagementSystem.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class demoMark {


    private String id;

    private long mark;
    private long mark1;
    private long mark2;
}
