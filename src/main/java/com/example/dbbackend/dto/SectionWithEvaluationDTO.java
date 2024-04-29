package com.example.dbbackend.dto;

import com.example.dbbackend.Model.Section;
import jakarta.persistence.Column;

/**
 * Data Transfer Object to encapsulate section information along with associated evaluation data.
 */
public class SectionWithEvaluationDTO {
    private Section section;
    private Integer levelACount;
    private Integer levelBCount;
    private Integer levelCCount;
    private Integer levelFCount;
    private String improvementSuggestion;

    // Constructor
    public SectionWithEvaluationDTO(Section section, Integer levelACount, Integer levelBCount, Integer levelCCount, Integer levelFCount, String improvementSuggestion) {
        this.section = section;
        this.levelACount = levelACount;
        this.levelBCount = levelBCount;
        this.levelCCount = levelCCount;
        this.levelFCount = levelFCount;
        this.improvementSuggestion = improvementSuggestion;
    }

    // Getters and Setters
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getLevelACount() {
        return levelACount;
    }

    public void setLevelACount(Integer levelACount) {
        this.levelACount = levelACount;
    }

    public Integer getLevelBCount() {
        return levelBCount;
    }

    public void setLevelBCount(Integer levelBCount) {
        this.levelBCount = levelBCount;
    }

    public Integer getLevelCCount() {
        return levelCCount;
    }

    public void setLevelCCount(Integer levelCCount) {
        this.levelCCount = levelCCount;
    }

    public Integer getLevelFCount() {
        return levelFCount;
    }

    public void setLevelFCount(Integer levelFCount) {
        this.levelFCount = levelFCount;
    }

    public String getImprovementSuggestion() {
        return improvementSuggestion;
    }

    public void setImprovementSuggestion(String improvementSuggestion) {
        this.improvementSuggestion = improvementSuggestion;
    }
    @Override
    public String toString() {
        return "SectionWithEvaluationDTO{" +
                "section=" + section +
                ", levelACount=" + levelACount +
                ", levelBCount=" + levelBCount +
                ", levelCCount=" + levelCCount +
                ", levelFCount=" + levelFCount +
                ", improvementSuggestion='" + improvementSuggestion + '\'' +
                '}';
    }
}
