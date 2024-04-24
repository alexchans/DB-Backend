package com.example.dbbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Degree_Course")
@IdClass(DegreeCourseId.class)
public class DegreeCourse {

    @Id
    @Column(name = "DegreeID")
    private int degreeId;

    @Id
    @Column(name = "CourseNumber", length = 8)
    private String courseNumber;

    @Column(name = "IsCore")
    private Boolean isCore;

    @ManyToOne
    @JoinColumn(name = "DegreeID", insertable = false, updatable = false)
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "CourseNumber", insertable = false, updatable = false)
    private Course course;

    // Getters and setters
    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Boolean getIsCore() {
        return isCore;
    }

    public void setIsCore(Boolean isCore) {
        this.isCore = isCore;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}


