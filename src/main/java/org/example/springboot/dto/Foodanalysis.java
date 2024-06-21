package org.example.springboot.dto;

import lombok.Data;
//某个商户所有菜品的评分、销量以及购买该菜品次数最多的人。
@Data
public class Foodanalysis {
    private String foodName;
    private Integer avgGrade;
    private Integer saleCount;
    private String PersonBuyMost;


}
