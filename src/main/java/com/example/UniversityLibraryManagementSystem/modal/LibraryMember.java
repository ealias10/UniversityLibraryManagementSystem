package com.example.UniversityLibraryManagementSystem.modal;

import com.example.UniversityLibraryManagementSystem.modal.enu.Status;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "library_member")
@Entity
@Builder
public class LibraryMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;


    @Pattern(regexp = "MEM-[A-Z0-9]{6}")
    @Column(name = "member_id",unique = true)
    private String memberId;

    @Column(name = "first_name",unique = true)
    private String firstName;

    @Column(name = "last_name",unique = true)
    private String lastName;


    @Email
    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "membership_date")
    private long membershipDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


}
