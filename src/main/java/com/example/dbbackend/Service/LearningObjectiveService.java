package com.example.dbbackend.Service;

import com.example.dbbackend.Model.LearningObjective;
import com.example.dbbackend.Repository.LearningObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningObjectiveService {

    @Autowired
    private LearningObjectiveRepository learningObjectiveRepository;

    public List<LearningObjective> getAllLearningObjectives() {
        return learningObjectiveRepository.findAll();
    }

    public Optional<LearningObjective> getLearningObjectiveByCode(String objectiveCode) {
        return learningObjectiveRepository.findById(objectiveCode);
    }

    public LearningObjective saveOrUpdateLearningObjective(LearningObjective learningObjective) {
        return learningObjectiveRepository.save(learningObjective);
    }

    public void deleteLearningObjective(String objectiveCode) {
        learningObjectiveRepository.deleteById(objectiveCode);
    }
}
