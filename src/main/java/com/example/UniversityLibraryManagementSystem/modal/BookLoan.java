package com.example.UniversityLibraryManagementSystem.modal;

import com.example.UniversityLibraryManagementSystem.modal.enu.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_loan")
@Entity
@Builder
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "book_Id",referencedColumnName = "id")
    @ToString.Exclude
    private Books book;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_Id",referencedColumnName = "id")
    @ToString.Exclude
    private LibraryMember member;

    @Column(name = "loan_date")
    private long loanDate;

    @Column(name = "due_date")
    private long dueDate;

    @Column(name = "return_date")
    private long returnDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Status status;






}
