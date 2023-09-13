package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findByUserId(Long userId);
}