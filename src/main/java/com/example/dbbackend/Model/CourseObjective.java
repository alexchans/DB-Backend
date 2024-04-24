package com.example.dbbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course_Objective")
@IdClass(CourseObjectiveId.class)
public class CourseObjective {

    @Id
    private String courseNumber;

    @Id
    private String objectiveCode;

    @ManyToOne
    @JoinColumn(name = "courseNumber", referencedColumnName = "CourseNumber", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "objectiveCode", referencedColumnName = "ObjectiveCode", insertable = false, updatable = false)
    private LearningObjective learningObjective;

    // Getters and setters
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
}
