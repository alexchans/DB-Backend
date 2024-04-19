package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}
