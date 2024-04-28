package com.example.dbbackend.Service;


import com.example.dbbackend.Model.DegreeCourse;
import com.example.dbbackend.Model.DegreeCourseId;
import com.example.dbbackend.Repository.DegreeCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeCourseService {

    @Autowired
    private DegreeCourseRepository degreeCourseRepository;

    public List<DegreeCourse> getAllDegreeCourses() {
        return degreeCourseRepository.findAll();
    }

    public List<DegreeCourse> getDegreeCoursesByDegreeId(int degreeId) {
        return degreeCourseRepository.findByDegreeId(degreeId);
    }
    public DegreeCourse saveOrUpdateDegreeCourse(DegreeCourse degreeCourse) {
        return degreeCourseRepository.save(degreeCourse);
    }

    public void deleteDegreeCourse(int degreeId, String courseNumber) {
        degreeCourseRepository.deleteById(new DegreeCourseId(degreeId, courseNumber));
    }
}
