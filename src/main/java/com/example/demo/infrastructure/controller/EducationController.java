package com.example.demo.infrastructure.controller;

import com.example.demo.application.service.EducationService;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users/{userId}/educations")
public class EducationController {
    @Autowired
    private EducationService educationService;
    @Autowired
    private UserService userService;
    @PostMapping
    public Education addEducation(@PathVariable Long userId, @RequestBody Education education) {
        education.setUser(userService.getUserById(userId));
        return educationService.saveEducation(education);
    }
    @GetMapping
    public List<Education> getByUserId(@PathVariable Long userId) {
        return educationService.getEducationsByUserId(userId);
    }
    @DeleteMapping("/{educationId}")
    public ResponseEntity<String> deleteEducation(@PathVariable Long userId, @PathVariable Long educationId) throws Exception {

        // Delete the education record
        educationService.deleteEducation(educationId);

        return ResponseEntity.ok("Education record deleted successfully");
    }

    // Add other CRUD endpoints as needed
}

