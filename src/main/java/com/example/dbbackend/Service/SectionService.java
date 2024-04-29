package com.example.dbbackend.Service;
import com.example.dbbackend.dto.SectionWithEvaluationDTO;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import com.example.dbbackend.Model.Evaluation;
import com.example.dbbackend.Repository.EvaluationRepository;
import com.example.dbbackend.Repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    private EvaluationRepository evaluationRepository;

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Optional<Section> getSectionById(SectionId sectionId) {
        return sectionRepository.findById(sectionId);
    }

    public Section saveOrUpdateSection(Section section) {
        return sectionRepository.save(section);
    }

    public void deleteSection(SectionId sectionId) {
        sectionRepository.deleteById(sectionId);
    }

    public List<Section> getRange(String courseNumber, String startSemester, int startYear, String endSemester, int endYear) {
        List<Section> sections = sectionRepository.findByCourseNumber(courseNumber);
        return sections.stream()
                .filter((section) -> sectionInRange(section, startSemester, startYear, endSemester, endYear))
                .toList();
    }

    private boolean sectionInRange(Section section, String startSemester, int startYear, String endSemester, int endYear) {
        double startYearValue = startYear;
        double endYearValue = endYear;
        if (startSemester.equals("Fall")) {
            startYearValue += 0.5;
        }else if(startSemester.equals("Summer")){
            startYearValue += 0.75;
        }
        if (endSemester.equals("Fall")) {
            endYearValue += 0.5;
        }else if(endSemester.equals("Summer")){
            endYearValue += 0.75;
        }
        double sectionYearValue = section.getYear();
        if (section.getSemester().equals("Fall")) {
            sectionYearValue += 0.5;
        }else if(section.getSemester().equals("Summer")){
            sectionYearValue += 0.75;
        }
        return sectionYearValue >= startYearValue && sectionYearValue <= endYearValue;
    }

    public List<Section> getSectionByInstructorAndSemester(int instructorId, String semester) {
        return sectionRepository.findByInstructorIdAndSemester(instructorId,semester);
    }

//    public List<Section> getSectionsByInstructorAndSemesterRange(Integer instructorId, String startSemester, String endSemester) {
//        return sectionRepository.findByInstructorIdAndSemesterBetween(instructorId, startSemester, endSemester);
//    }

    public List<Section> getSectionsByInstructorAndSemesterRange(Integer instructorId, String startSemester, int startYear, String endSemester, int endYear) {
        return sectionRepository.findSectionsByInstructorAndSemesterRange(instructorId, startSemester, startYear, endSemester, endYear);
    }

    public List<Evaluation> evaluateSections(String semester) {
        // Assuming semester is stored in the sectionNumber attribute of Evaluation entity
        return evaluationRepository.findBySectionNumberContaining(semester);
    }

//    public List<Section> getSectionsByPassRate(String semester, double passRatePercentage) {
//        // Implement logic to calculate pass rate and return sections that meet the criteria
//        return evaluationRepository.findBySectionNumberSemesterAbovePassRate(semester,passRatePercentage);
//    }
    public List<SectionWithEvaluationDTO> findSectionsByPassRate(String semester, double passRatePercentage) {
        return sectionRepository.findSectionsByPassRate(semester, passRatePercentage);
    }
//    public List<Section> findSectionsByPassRate(String semester, double passRatePercentage) {
//        // Get evaluations for the given semester
//        List<Evaluation> evaluations = evaluationRepository.findBySectionNumberContaining(semester);
//
//        // Filter sections based on pass rate
//        List<Section> sections = evaluations.stream()
//                .filter(evaluation -> {
//                    // Calculate pass rate for each evaluation
//                    double passRate = calculatePassRate(evaluation);
//                    // Check if pass rate is higher than the given percentage
//                    return passRate > passRatePercentage;
//                })
//                .map(evaluation -> {
//                    // Create section object from evaluation
//                    Section section = new Section();
//                    section.setSectionNumber(evaluation.getSectionNumber());
//                    // Set other section properties if needed
//                    return section;
//                })
//                .toList(); // Convert stream to list
//
//        return sections;
//    }
//
//    private double calculatePassRate(Evaluation evaluation) {
//        // Calculate total number of students
//        int totalStudents = evaluation.getLevelACount() + evaluation.getLevelBCount() +
//                evaluation.getLevelCCount() + evaluation.getLevelFCount();
//
//        // Calculate pass rate
//        double passRate = (double) (evaluation.getLevelACount() + evaluation.getLevelBCount() +
//                evaluation.getLevelCCount()) / totalStudents;
//
//        return passRate;
//    }
}
