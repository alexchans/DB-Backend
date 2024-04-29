package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import com.example.dbbackend.dto.SectionWithEvaluationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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

//    @Query("SELECT s FROM Section s WHERE s.semester = :semester AND s.sectionNumber IN " +
//            "(SELECT e.sectionNumber FROM Evaluation e " +
//            "WHERE (e.levelACount + e.levelBCount + e.levelCCount) / " +
//            "(e.levelACount + e.levelBCount + e.levelCCount + e.levelFCount)*100 > :passRatePercentage)")
//    List<Section> findSectionsByPassRate(@Param("semester") String semester, @Param("passRatePercentage") double passRatePercentage);

//    @Query("SELECT new com.example.dbbackend.dto.SectionWithEvaluationDTO(s, e.levelACount, e.levelBCount, e.levelCCount, e.levelFCount, e.improvementSuggestion) FROM Section s LEFT JOIN Evaluation e ON s.sectionNumber = e.sectionNumber AND s.semester = e.semester WHERE s.semester = :semester")
//    List<SectionWithEvaluationDTO> findAllSectionsWithOptionalEvaluations(@Param("semester") String semester);

    @Query("SELECT new com.example.dbbackend.dto.SectionWithEvaluationDTO(s, e.levelACount, e.levelBCount, e.levelCCount, e.levelFCount, e.improvementSuggestion) " +
            "FROM Section s " +
            "LEFT JOIN Evaluation e ON s.sectionNumber = e.sectionNumber " +
            "WHERE s.semester = :semester " +
            "AND (e.levelACount + e.levelBCount + e.levelCCount) / " +
            "(e.levelACount + e.levelBCount + e.levelCCount + e.levelFCount) * 100 > :passRatePercentage")
    List<SectionWithEvaluationDTO> findSectionsByPassRate(@Param("semester") String semester, @Param("passRatePercentage") double passRatePercentage);




}