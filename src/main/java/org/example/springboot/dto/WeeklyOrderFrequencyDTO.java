package org.example.springboot.dto;

import lombok.Data;

@Data
public class WeeklyOrderFrequencyDTO {
    private String week;
    private Integer orderCount;
}
