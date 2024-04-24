package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.DegreeCourse;
import com.example.dbbackend.Model.DegreeCourseId;
import com.example.dbbackend.Service.DegreeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/degreeCourses")
public class DegreeCourseController {

    @Autowired
    private DegreeCourseService degreeCourseService;

    @GetMapping("/")
    public ResponseEntity<List<DegreeCourse>> getAllDegreeCourses() {
        List<DegreeCourse> degreeCourses = degreeCourseService.getAllDegreeCourses();
        return ResponseEntity.ok(degreeCourses);
    }

    @GetMapping("/{degreeId}/{courseNumber}")
    public ResponseEntity<DegreeCourse> getDegreeCourse(@PathVariable int degreeId, @PathVariable String courseNumber) {
        return degreeCourseService.getDegreeCourseById(degreeId, courseNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<DegreeCourse> createOrUpdateDegreeCourse(@RequestBody DegreeCourse degreeCourse) {
        DegreeCourse savedDegreeCourse = degreeCourseService.saveOrUpdateDegreeCourse(degreeCourse);
        return ResponseEntity.ok(savedDegreeCourse);
    }

    @DeleteMapping("/{degreeId}/{courseNumber}")
    public ResponseEntity<Void> deleteDegreeCourse(@PathVariable int degreeId, @PathVariable String courseNumber) {
        degreeCourseService.deleteDegreeCourse(degreeId, courseNumber);
        return ResponseEntity.ok().build();
    }
}


