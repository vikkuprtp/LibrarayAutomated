package com.skilloVillaProjLib.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class borrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn
    private  libraryBooks libraryBooks;





}
