package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;

@Data

@Entity
public class Task {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private LocalDate date;

    private String description;

    private boolean done;
}
