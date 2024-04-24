package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Instructor;
import com.example.dbbackend.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId);
    }

    public Instructor saveOrUpdateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }
}
