package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Degree;
import com.example.dbbackend.Service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
