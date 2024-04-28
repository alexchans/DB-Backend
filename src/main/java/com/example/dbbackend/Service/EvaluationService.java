package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Repository.EvaluationRepository;
import com.example.dbbackend.Repository.SectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private SectionRepository sectionRepository;

    // Parameter instructor is of type int as it requests the ID of the instructor
    public List<Section> getSectionsByInstructorAndSemester(String degreeId, String semester, int instructor) {
        List<Section> allSections = sectionRepository.findAll();
        System.out.println("allSections:" + allSections);
        List<Section> result = new ArrayList<Section>(); // empty list
        
        for (Section section : allSections) {
            if (section.getSemester().equals(semester) && section.getInstructorId() == instructor)
                result.add(section); // add each qualifying section to result list
        }
        System.out.println("returning result:" + result);
        return result; // I have a list of all qualifying sections
    }
}
