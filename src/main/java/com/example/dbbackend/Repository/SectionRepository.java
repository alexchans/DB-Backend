package com.example.dbbackend.Repository;

import com.example.dbbackend.Model.Section;
import com.example.dbbackend.Model.SectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, SectionId> {
}
