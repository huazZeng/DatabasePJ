package org.example.springboot.dto;

import lombok.Data;

@Data
public class Foodanalysis {
    private String foodName;
    private Integer avgGrade;
    private Integer saleCount;
    private String PersonBuyMost;


}
