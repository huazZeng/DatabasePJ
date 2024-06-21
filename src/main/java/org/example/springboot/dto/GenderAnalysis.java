package org.example.springboot.dto;

import lombok.Data;

@Data
public class GenderAnalysis {
    private String ageGroup;

    private Integer commentCount;
    private Double averageRating;

}
