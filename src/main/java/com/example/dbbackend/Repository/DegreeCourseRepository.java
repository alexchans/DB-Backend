package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.DegreeCourse;
import com.example.dbbackend.Model.DegreeCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeCourseRepository extends JpaRepository<DegreeCourse, DegreeCourseId> {
}
