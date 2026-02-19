package com.snapnote.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate date;

    @Column(length = 5000)
    private String description;

    // 🔥 CONNECT NOTE TO USER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
