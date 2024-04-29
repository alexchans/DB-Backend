package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Optional<Evaluation> getEvaluationById(int evaluationId) {
        return evaluationRepository.findById(evaluationId);
    }

    public Evaluation saveOrUpdateEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(int evaluationId) {
        evaluationRepository.deleteById(evaluationId);
    }
    public List<Evaluation> findByInstructor(int degreeId, String courseNumber, String sectionNumber){return evaluationRepository.findByDegreeIdAndCourseNumberAndSectionNumber(degreeId,courseNumber,sectionNumber); }
}
