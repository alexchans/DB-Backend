package com.example.dbbackend.Model;

import java.io.Serializable;
import java.util.Objects;

public class DegreeCourseId implements Serializable {
    private int degreeId;
    private String courseNumber;

    // Constructors, getters, setters, hashCode, equals
    public DegreeCourseId() {}

    public DegreeCourseId(int degreeId, String courseNumber) {
        this.degreeId = degreeId;
        this.courseNumber = courseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DegreeCourseId that = (DegreeCourseId) o;
        return degreeId == that.degreeId &&
                Objects.equals(courseNumber, that.courseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(degreeId, courseNumber);
    }
}
