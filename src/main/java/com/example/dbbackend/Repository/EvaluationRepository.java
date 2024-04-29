package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    List<Evaluation> findByDegreeIdAndCourseNumberAndSectionNumber(int degreeId, String courseNumber, String sectionNumber);
}
