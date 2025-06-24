package com.example.UniversityLibraryManagementSystem.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    @JoinColumn(name = "subject_Id",referencedColumnName = "id")
    @ToString.Exclude
    private Subject subject;



    @ElementCollection
    @JoinTable(name = "marks", joinColumns = @JoinColumn(name = "id"))
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @CollectionTable(name = "markd", joinColumns = @JoinColumn(name = "mark_id", referencedColumnName = "id"))
    private List<Marks> marksList;





}
