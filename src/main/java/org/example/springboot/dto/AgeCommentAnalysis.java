package org.example.springboot.dto;

import lombok.Data;

@Data
public class AgeCommentAnalysis {
    private String ageGroup;
    private Integer commentCount;
    private Double averageRating;
}
