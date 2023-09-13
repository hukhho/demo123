package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.Template;
import com.example.demo.domain.model.TemplateProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplatePropertiesRepository extends JpaRepository<TemplateProperties, Long> {

}