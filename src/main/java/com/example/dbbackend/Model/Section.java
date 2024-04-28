package com.example.dbbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Section")
@IdClass(SectionId.class)
public class Section {

    @Id
    private String sectionNumber;

    @Id
    private String courseNumber;

    @Id
    private String semester;

    @Id
    private int year;

    private int instructorId;

    private int enrolledStudents;

    @ManyToOne
    @JoinColumn(name = "courseNumber", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructorId", insertable = false, updatable = false)
    private Instructor instructor;

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

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}


