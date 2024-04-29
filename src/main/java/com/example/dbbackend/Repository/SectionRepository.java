package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, SectionId> {
    List<Section> findByCourseNumber(String courseNumber);
    List<Section> findByInstructorIdAndSemester(int instructorId, String semester);
//    List<Section> findByInstructorIdAndSemesterBetween(Integer instructorId, String startSemester, String endSemester);

    @Query("SELECT s FROM Section s WHERE s.instructorId = :instructorId AND ((s.year > :startYear) OR (s.year = :startYear AND s.semester >= :startSemester)) AND ((s.year < :endYear) OR (s.year = :endYear AND s.semester <= :endSemester))")
    List<Section> findSectionsByInstructorAndSemesterRange(Integer instructorId, String startSemester, int startYear, String endSemester, int endYear);
}
