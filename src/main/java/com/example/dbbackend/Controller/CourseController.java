package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Course;
import com.example.dbbackend.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.dbbackend.Model.Course;
import com.example.dbbackend.Service.CourseService;


@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{courseNumber}")
    public ResponseEntity<Course> getCourseByNumber(@PathVariable String courseNumber) {
        return courseService.getCourseByNumber(courseNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Course> createOrUpdateCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveOrUpdateCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    @DeleteMapping("/{courseNumber}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseNumber) {
        courseService.deleteCourse(courseNumber);
        return ResponseEntity.ok().build();
    }
}

