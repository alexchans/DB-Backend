package com.example.dbbackend.Controller;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import com.example.dbbackend.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/")
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return ResponseEntity.ok(sections);
    }

    @GetMapping("/{sectionNumber}/{courseNumber}/{semester}/{year}")
    public ResponseEntity<Section> getSectionById(@PathVariable String sectionNumber,
                                                  @PathVariable String courseNumber,
                                                  @PathVariable String semester,
                                                  @PathVariable int year) {
        SectionId sectionId = new SectionId(sectionNumber, courseNumber, semester, year);
        return sectionService.getSectionById(sectionId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Section> createOrUpdateSection(@RequestBody Section section) {
        Section savedSection = sectionService.saveOrUpdateSection(section);
        return ResponseEntity.ok(savedSection);
    }

    @DeleteMapping("/{sectionNumber}/{courseNumber}/{semester}/{year}")
    public ResponseEntity<Void> deleteSection(@PathVariable String sectionNumber,
                                              @PathVariable String courseNumber,
                                              @PathVariable String semester,
                                              @PathVariable int year) {
        SectionId sectionId = new SectionId(sectionNumber, courseNumber, semester, year);
        sectionService.deleteSection(sectionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/range")
    public ResponseEntity<List<Section>> getAllSectionsInRange(@RequestParam String courseNumber, @RequestParam String startSemester, @RequestParam int startYear, @RequestParam String endSemester, @RequestParam int endYear) {
        List<Section> sections = sectionService.getRange(courseNumber,startSemester,startYear,endSemester,endYear);
        return ResponseEntity.ok(sections);
    }

    @GetMapping("/instructorSections/{instructorId}/{semester}")
    public ResponseEntity<List<Section>> getInstructorSections(@PathVariable int instructorId, @PathVariable String semester) {
        List<Section> sections = sectionService.getSectionByInstructorAndSemester(instructorId,semester);
        return ResponseEntity.ok(sections);
    }

//    @GetMapping("/instructorSectionsRange")
//    public ResponseEntity<List<Section>> getSectionsByInstructorAndSemesterRange(@RequestParam Integer instructorId, @RequestParam String startSemester, @RequestParam String endSemester) {
//        List<Section> sections = sectionService.getSectionsByInstructorAndSemesterRange(instructorId, startSemester, endSemester);
//        if (sections.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(sections);
//    }

    @GetMapping("/instructorSectionsRange")
    public ResponseEntity<List<Section>> getSectionsByInstructorAndSemesterRange(
            @RequestParam Integer instructorId,
            @RequestParam String startSemester,
            @RequestParam int startYear,  // Added startYear
            @RequestParam String endSemester,
            @RequestParam int endYear) {  // Added endYear
        List<Section> sections = sectionService.getSectionsByInstructorAndSemesterRange(instructorId, startSemester, startYear, endSemester, endYear);
        if (sections.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sections);
    }

}
