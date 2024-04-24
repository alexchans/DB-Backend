package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Course;
import com.example.dbbackend.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByNumber(String courseNumber) {
        return courseRepository.findById(courseNumber);
    }

    public Course saveOrUpdateCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(String courseNumber) {
        courseRepository.deleteById(courseNumber);
    }
}
