package org.example.springboot.dto;

import lombok.Data;

@Data
public class CollectAnalysis{
        private int foodId;
        private String foodName;
        private int salesLastWeek;
        private int salesLastMonth;
        private int salesLastYear;

}
