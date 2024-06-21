package org.example.springboot.dto;
import lombok.Data;

@Data
public class HabitAnalysis {

        private Long userId;
        private Long foodId;
        private String foodName;
        private Integer purchaseCount;

}
