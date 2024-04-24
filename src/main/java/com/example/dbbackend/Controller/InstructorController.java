package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Instructor;
import com.example.dbbackend.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable int instructorId) {
        return instructorService.getInstructorById(instructorId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Instructor> createOrUpdateInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.saveOrUpdateInstructor(instructor);
        return ResponseEntity.ok(savedInstructor);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable int instructorId) {
        instructorService.deleteInstructor(instructorId);
        return ResponseEntity.ok().build();
    }
}
