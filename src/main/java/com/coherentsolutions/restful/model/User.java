// File: User.java
package com.coherentsolutions.restful.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data // Lombok annotation for getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Required fields
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    // Optional fields
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;
}
