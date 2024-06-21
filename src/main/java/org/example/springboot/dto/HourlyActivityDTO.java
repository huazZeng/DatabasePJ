package org.example.springboot.dto;

import lombok.Data;

@Data
public class HourlyActivityDTO {
    private Integer hourOfDay; // Range: 0-23
    private Integer orderCount;

}

