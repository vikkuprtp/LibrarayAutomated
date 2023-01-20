package com.skilloVillaProjLib.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int roleId=2;
    private String phoneNumber;
    private String  address;
    @ManyToOne
    borrowRecord borrowRecords;
    @ManyToOne
    returnRecord returnRecords;

}
