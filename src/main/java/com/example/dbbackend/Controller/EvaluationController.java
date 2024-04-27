package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import com.example.dbbackend.Service.EvaluationService;
import com.example.dbbackend.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/Evaluation")
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
    
    private static final Logger logger = LoggerFactory.getLogger(EvaluationController.class);
    
    @PostMapping("/{DegreeId}/{Semester}/{Instructor}")
    public ResponseEntity<List<Section>> getSectionsByInstructorAndSemester(
            @RequestParam String DegreeId, 
            @RequestParam String Semester, 
            @RequestParam int Instructor) {
        logger.info("I hate logger");
        System.out.println(" DegreeId:" + DegreeId + " Semester:" + Semester + " Instructor:" + Instructor);
        List<Section> sections = evaluationService.getSectionsByInstructorAndSemester(DegreeId, Semester, Instructor);
        System.out.println("sections:" + sections);
        return ResponseEntity.ok(sections);
    }
}
