package com.example.dbbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Learning_Objective")
public class LearningObjective {

    @Id
    @Column(name = "ObjectiveCode", length = 255)
    private String objectiveCode;

    @Column(name = "Title", length = 120)
    private String title;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    // Getters and setters
    public String getObjectiveCode() {
        return objectiveCode;
    }

    public void setObjectiveCode(String objectiveCode) {
        this.objectiveCode = objectiveCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
