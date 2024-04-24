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
}
