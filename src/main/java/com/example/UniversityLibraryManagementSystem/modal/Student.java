package com.example.collage.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;


    @Column(name = "name",unique = true)
    private String name;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "auther_Id",referencedColumnName = "id")
    @ToString.Exclude
    private Departement departement;
}
