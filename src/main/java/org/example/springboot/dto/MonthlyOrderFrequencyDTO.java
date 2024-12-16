package org.example.springboot.dto;

import lombok.Data;

@Data
public class MonthlyOrderFrequencyDTO {
    private String month; // Format: YYYY-MM (e.g., 2024-06 for June 2024)
    private Integer orderCount;

    // Getters and Setters
}

