// File: ZipCode.java
package com.coherentsolutions.restful.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zip_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;
}

