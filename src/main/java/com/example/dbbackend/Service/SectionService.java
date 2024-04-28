package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import com.example.dbbackend.Repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

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
        }
        if (endSemester.equals("Fall")) {
            endYearValue += 0.5;
        }
        double sectionYearValue = section.getYear();
        if (section.getSemester().equals("Fall")) {
            sectionYearValue += 0.5;
        }
        return sectionYearValue >= startYearValue && sectionYearValue <= endYearValue;
    }
}
