package com.snapnote.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 USER NAME
    @Column(nullable = false)
    private String name;

    // 🔥 EMAIL
    @Column(nullable = false, unique = true)
    private String email;

    // 🔥 PASSWORD
    @Column(nullable = false)
    private String password;
}
