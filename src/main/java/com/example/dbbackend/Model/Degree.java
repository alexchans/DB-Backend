package com.example.dbbackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int degreeID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String level;

    // Constructors
    public Degree() {
    }

    public Degree(String name, String level) {
        this.name = name;
        this.level = level;
    }

    // Getters and Setters
    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

