package org.example.springboot.dto;

import lombok.Data;

@Data
public class GenderCommentAnalysis {
    private String Gender;

    private Integer commentCount;
    private Double averageRating;

}
