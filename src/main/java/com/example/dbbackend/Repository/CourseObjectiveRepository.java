package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.CourseObjective;
import com.example.dbbackend.Model.CourseObjectiveId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseObjectiveRepository extends JpaRepository<CourseObjective, CourseObjectiveId> {
    List<CourseObjective> findByCourseNumber(String courseNumber);
}
