package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.CourseObjective;
import com.example.dbbackend.Model.CourseObjectiveId;
import com.example.dbbackend.Repository.CourseObjectiveRepository;
import com.example.dbbackend.Service.CourseObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseObjectives")
public class CourseObjectiveController {

    @Autowired
    private CourseObjectiveService courseObjectiveService;

    @Autowired
    CourseObjectiveRepository COR;
    @GetMapping("/")
    public ResponseEntity<List<CourseObjective>> getAllCourseObjectives() {
        List<CourseObjective> objectives = courseObjectiveService.getAllCourseObjectives();
        return ResponseEntity.ok(objectives);
    }

    @GetMapping("/{courseNumber}/{objectiveCode}")
    public ResponseEntity<CourseObjective> getCourseObjectiveById(@PathVariable String courseNumber, @PathVariable String objectiveCode) {
        CourseObjectiveId id = new CourseObjectiveId(courseNumber, objectiveCode);
        return courseObjectiveService.getCourseObjectiveById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<CourseObjective> createOrUpdateCourseObjective(@RequestBody CourseObjective courseObjective) {
        CourseObjective savedObjective = courseObjectiveService.saveOrUpdateCourseObjective(courseObjective);
        return ResponseEntity.ok(savedObjective);
    }

    @DeleteMapping("/{courseNumber}/{objectiveCode}")
    public ResponseEntity<Void> deleteCourseObjective(@PathVariable String courseNumber, @PathVariable String objectiveCode) {
        CourseObjectiveId id = new CourseObjectiveId(courseNumber, objectiveCode);
        courseObjectiveService.deleteCourseObjective(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get/{courseNumber}")
    List<CourseObjective> getCourseObjectiveByCourse(@PathVariable String courseNumber) {
       return courseObjectiveService.getCourseObjectiveByCourse(courseNumber);
    }
}
