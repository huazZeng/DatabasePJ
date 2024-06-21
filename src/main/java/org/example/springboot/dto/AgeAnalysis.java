package org.example.springboot.dto;

import lombok.Data;

@Data
public class AgeAnalysis {
    private String ageGroup;
    private Integer commentCount;
    private Double averageRating;
}
