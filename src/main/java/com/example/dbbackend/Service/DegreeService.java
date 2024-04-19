package com.example.dbbackend.Service;

import com.example.dbbackend.Model.Degree;
import com.example.dbbackend.Repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    public Degree createDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    public Optional<Degree> getDegreeById(int degreeID) {
        return degreeRepository.findById(degreeID);
    }
}
