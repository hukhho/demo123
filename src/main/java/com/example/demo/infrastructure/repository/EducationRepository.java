package com.example.demo.infrastructure.repository;
import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByUserId(Long userId);
}