package com.example.UniversityLibraryManagementSystem.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marks")
@Entity
@Builder
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;


    @Column(name = "mark")
    private long mark;


}
