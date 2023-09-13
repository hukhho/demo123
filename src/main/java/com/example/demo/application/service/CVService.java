package com.example.demo.application.service;

import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.Experience;
import com.example.demo.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CVService {

    @Autowired
    private UserService userService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private ExperienceService experienceService;

//    public File generateCV(Long userId, String templatePath) {
//        User user = userService.getUserById(userId);
//        List<Education> educations = educationService.getEducationsByUserId(userId);
//        List<Experience> experiences = experienceService.getExperiencesByUserId(userId);
//
//        // Use docx4j or another library to load the template, replace placeholders, and save the generated CV
//
//        return generatedCVFile;
//    }
}