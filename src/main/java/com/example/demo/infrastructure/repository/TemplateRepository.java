package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Education;
import com.example.demo.domain.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> {

}