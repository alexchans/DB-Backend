package com.example.dbbackend.Model;

import java.io.Serializable;
import java.util.Objects;

public class SectionId implements Serializable {
    private String sectionNumber;
    private String courseNumber;
    private String semester;
    private int year;

    // Constructors
    public SectionId() {
    }

    public SectionId(String sectionNumber, String courseNumber, String semester, int year) {
        this.sectionNumber = sectionNumber;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.year = year;
    }

    // Getters and setters
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(sectionNumber, courseNumber, semester, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionId sectionId = (SectionId) o;
        return year == sectionId.year &&
                Objects.equals(sectionNumber, sectionId.sectionNumber) &&
                Objects.equals(courseNumber, sectionId.courseNumber) &&
                Objects.equals(semester, sectionId.semester);
    }
}
