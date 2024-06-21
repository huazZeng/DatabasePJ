package org.example.springboot.dto;

import lombok.Data;

@Data
public class RoleAnalysis {
    private String userRole;
    private Integer orderCount;
    private Double averageRating;
}
