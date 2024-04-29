package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    List<Evaluation> findByDegreeIdAndCourseNumberAndSectionNumber(int degreeId, String courseNumber, String sectionNumber);

    List<Evaluation> findBySectionNumberContaining(String semester);
}
