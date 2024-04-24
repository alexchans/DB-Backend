package com.example.dbbackend.Service;

import com.example.dbbackend.Model.CourseObjective;
import com.example.dbbackend.Model.CourseObjectiveId;
import com.example.dbbackend.Repository.CourseObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseObjectiveService {

    @Autowired
    private CourseObjectiveRepository courseObjectiveRepository;

    public List<CourseObjective> getAllCourseObjectives() {
        return courseObjectiveRepository.findAll();
    }

    public Optional<CourseObjective> getCourseObjectiveById(CourseObjectiveId courseObjectiveId) {
        return courseObjectiveRepository.findById(courseObjectiveId);
    }

    public CourseObjective saveOrUpdateCourseObjective(CourseObjective courseObjective) {
        return courseObjectiveRepository.save(courseObjective);
    }

    public void deleteCourseObjective(CourseObjectiveId courseObjectiveId) {
        courseObjectiveRepository.deleteById(courseObjectiveId);
    }
}
