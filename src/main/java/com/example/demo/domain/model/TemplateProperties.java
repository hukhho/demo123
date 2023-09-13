package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // Corresponds to the 'name' attribute in XML
    private boolean list; // Corresponds to the 'list' attribute in XML
    private String imageName; // Corresponds to the 'imageName' attribute in XML
    private String syntaxKind; // Corresponds to the 'syntaxKind' attribute in XML
    @ManyToOne
    private Template template; // Assuming there's a relationship to a 'Template' entity
}