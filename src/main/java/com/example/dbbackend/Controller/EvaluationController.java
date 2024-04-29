package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/")
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/{evaluationId}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable int evaluationId) {
        return evaluationService.getEvaluationById(evaluationId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Evaluation> createOrUpdateEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation savedEvaluation = evaluationService.saveOrUpdateEvaluation(evaluation);
        return ResponseEntity.ok(savedEvaluation);
    }

    @DeleteMapping("/{evaluationId}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable int evaluationId) {
        evaluationService.deleteEvaluation(evaluationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findSpecifics/{degreeId}/{courseNumber}/{sectionNumber}")
    public ResponseEntity<List<Evaluation>> getByInfo(@PathVariable int degreeId, @PathVariable String courseNumber, @PathVariable String sectionNumber) {
        List<Evaluation> evaluations = evaluationService.findByInstructor(degreeId,courseNumber,sectionNumber);
        return ResponseEntity.ok(evaluations);
    }
}
