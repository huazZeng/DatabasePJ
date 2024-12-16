package org.example.springboot.dto;
import lombok.Data;
//一段时间内某个商户的忠实粉丝在该商户的消费分布
@Data
public class HabitAnalysis {

        private Long userId;
        private Long foodId;
        private String foodName;
        private Integer purchaseCount;

}
