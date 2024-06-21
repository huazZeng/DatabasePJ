package org.example.springboot.dto;

import lombok.Data;
//某用户收藏的各个菜品在一段时间（近一周，近一月，近一年）内不同点餐方式的销量可进行筛选。
@Data
public class CollectAnalysis{
        private int foodId;
        private String foodName;
        private int salesLastWeek;
        private  int is_queue_order;
        private int salesLastMonth;
        private int salesLastYear;

}
