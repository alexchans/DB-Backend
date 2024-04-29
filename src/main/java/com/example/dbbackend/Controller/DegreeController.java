package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Degree;
import com.example.dbbackend.Service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degrees")
public class DegreeController {

    @Autowired
    private DegreeService degreeService;

    @PostMapping("/create")
    public ResponseEntity<Degree> createDegree(@RequestBody Degree degree) {
        Degree createdDegree = degreeService.createDegree(degree);
        return ResponseEntity.ok(createdDegree);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable int id) {
        return degreeService.getDegreeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Degree>> getAllDegrees() {
        List<Degree> degrees = degreeService.getAllDegrees();
        return ResponseEntity.ok(degrees);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDegree(@PathVariable int id) {
        boolean isDeleted = degreeService.deleteDegree(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
