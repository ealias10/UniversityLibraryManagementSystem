package com.example.UniversityLibraryManagementSystem.modal;

import com.example.UniversityLibraryManagementSystem.modal.enu.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
@Entity
@Builder
public class Reservation {

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

    @Column(name = "reservation_date")
    private long reservationDate;



    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "pickup_expiry_date")
    private long pickupExpiryDate;



}
