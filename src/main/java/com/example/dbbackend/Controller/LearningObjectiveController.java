package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.LearningObjective;
import com.example.dbbackend.Service.LearningObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learningObjectives")
public class LearningObjectiveController {

    @Autowired
    private LearningObjectiveService learningObjectiveService;

    @GetMapping("/")
    public ResponseEntity<List<LearningObjective>> getAllLearningObjectives() {
        List<LearningObjective> objectives = learningObjectiveService.getAllLearningObjectives();
        return ResponseEntity.ok(objectives);
    }

    @GetMapping("/{objectiveCode}")
    public ResponseEntity<LearningObjective> getLearningObjectiveByCode(@PathVariable String objectiveCode) {
        return learningObjectiveService.getLearningObjectiveByCode(objectiveCode)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<LearningObjective> createOrUpdateLearningObjective(@RequestBody LearningObjective learningObjective) {
        LearningObjective savedObjective = learningObjectiveService.saveOrUpdateLearningObjective(learningObjective);
        return ResponseEntity.ok(savedObjective);
    }

    @DeleteMapping("/{objectiveCode}")
    public ResponseEntity<Void> deleteLearningObjective(@PathVariable String objectiveCode) {
        learningObjectiveService.deleteLearningObjective(objectiveCode);
        return ResponseEntity.ok().build();
    }
}
