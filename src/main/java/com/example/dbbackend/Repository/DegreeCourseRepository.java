package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.DegreeCourse;
import com.example.dbbackend.Model.DegreeCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DegreeCourseRepository extends JpaRepository<DegreeCourse, DegreeCourseId> {
    List<DegreeCourse> findByDegreeId(int degreeId);
}
