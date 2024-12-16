package org.example.springboot.dto;

import lombok.Data;

@Data
public class RoleCommentAnalysis {
    private String userRole;
    private Integer commentCount;
    private Double averageRating;
}
