package com.example.demo.application.service;

import com.example.demo.domain.model.TemplateProperties;
import com.example.demo.infrastructure.repository.TemplatePropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplatePropertiesService {

    @Autowired
    private TemplatePropertiesRepository templatePropertiesRepository;

    public void saveTemplateProperties(List<TemplateProperties> propertiesList) {
        templatePropertiesRepository.saveAll(propertiesList);
    }
}