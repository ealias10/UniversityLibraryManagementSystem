package com.example.collage.modal;

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

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_Id",referencedColumnName = "id")
    @ToString.Exclude
    private Departement departement;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "stud_id",referencedColumnName = "id")
    @ToString.Exclude
    private Student student;
}
