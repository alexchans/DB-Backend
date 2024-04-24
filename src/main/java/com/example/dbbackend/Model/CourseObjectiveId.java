package com.example.dbbackend.Model;

import java.io.Serializable;
import java.util.Objects;

public class CourseObjectiveId implements Serializable {
    private String courseNumber;
    private String objectiveCode;

    // Constructors
    public CourseObjectiveId() {
    }

    public CourseObjectiveId(String courseNumber, String objectiveCode) {
        this.courseNumber = courseNumber;
        this.objectiveCode = objectiveCode;
    }

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

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseObjectiveId)) return false;
        CourseObjectiveId that = (CourseObjectiveId) o;
        return Objects.equals(getCourseNumber(), that.getCourseNumber()) &&
                Objects.equals(getObjectiveCode(), that.getObjectiveCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseNumber(), getObjectiveCode());
    }
}
