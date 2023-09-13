package com.example.demo.application.service;

import com.example.demo.domain.model.Education;
import com.example.demo.infrastructure.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public Education saveEducation(Education education) {


        return educationRepository.save(education);
    }
    public void deleteEducation(Long educationId) throws Exception {
        // Implement the logic to delete an education record
        Optional<Education> education = educationRepository.findById(educationId);
        if (education.isPresent()) {
            educationRepository.delete(education.get());
        } else {
            throw new Exception("Error");
        }
    }

    public List<Education> getEducationsByUserId(Long userId) {
        return educationRepository.findByUserId(userId);
    }

    // Add other CRUD methods as needed
}
