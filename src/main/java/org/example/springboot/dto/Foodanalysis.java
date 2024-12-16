package org.example.springboot.dto;

import lombok.Data;
//某个商户所有菜品的评分、销量以及购买该菜品次数最多的人。
@Data
public class Foodanalysis {
    private  Integer id;
    private String foodName;
    private Integer avgGrade;
    private Integer saleCount;
    private String PersonBuyMost;

    public void setAvgGrade(Integer avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPersonBuyMost(String personBuyMost) {
        PersonBuyMost = personBuyMost;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
}
