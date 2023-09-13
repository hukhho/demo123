package com.example.demo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvGenerationRequest {
    private Long userId;
    private Long templateId;
    private List<Long> educationIds;

}
