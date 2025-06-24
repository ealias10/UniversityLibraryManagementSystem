package com.example.UniversityLibraryManagementSystem.modal;

import com.example.UniversityLibraryManagementSystem.modal.enu.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "books")
@Entity
@Builder
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;




    @Pattern(regexp = "ISBN-[0-9]{10,13}")
    @Column(name = "isbn")
    private String isbn;


    @Column(name = "title")
    private String title;


    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "publication_year")
    private long publicationYear;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "total_copies")
    private Integer totalCopies;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "auther_Id",referencedColumnName = "id")
    @ToString.Exclude
    private Author author;
}
