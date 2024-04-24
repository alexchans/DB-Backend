package com.example.dbbackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluationId;

    private int degreeId;
    private String sectionNumber;
    private String courseNumber;
    private String objectiveCode;
    private String method;

    private int levelACount;
    private int levelBCount;
    private int levelCCount;
    private int levelFCount;

    @Column(columnDefinition = "TEXT")
    private String improvementSuggestion;

    // Getters and setters
    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getObjectiveCode() {
        return objectiveCode;
    }

    public void setObjectiveCode(String objectiveCode) {
        this.objectiveCode = objectiveCode;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getLevelACount() {
        return levelACount;
    }

    public void setLevelACount(int levelACount) {
        this.levelACount = levelACount;
    }

    public int getLevelBCount() {
        return levelBCount;
    }

    public void setLevelBCount(int levelBCount) {
        this.levelBCount = levelBCount;
    }

    public int getLevelCCount() {
        return levelCCount;
    }

    public void setLevelCCount(int levelCCount) {
        this.levelCCount = levelCCount;
    }

    public int getLevelFCount() {
        return levelFCount;
    }

    public void setLevelFCount(int levelFCount) {
        this.levelFCount = levelFCount;
    }

    public String getImprovementSuggestion() {
        return improvementSuggestion;
    }

    public void setImprovementSuggestion(String improvementSuggestion) {
        this.improvementSuggestion = improvementSuggestion;
    }
}
