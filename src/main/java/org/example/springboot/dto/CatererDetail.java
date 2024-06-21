package org.example.springboot.dto;

import lombok.Data;
import org.example.springboot.entity.Food;

import java.util.List;

@Data
public class CatererDetail {
    private Integer id;

    private String name;

    private String address;

    private String mainFoodName;

    private List<Food> foodList;

}
