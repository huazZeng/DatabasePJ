package org.example.springboot.dto;

import lombok.Data;
import org.example.springboot.entity.FoodComment;
import org.example.springboot.entity.Price;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FoodDetail {
    private Integer id;

    private Integer catererId;

    private String name;

    private BigDecimal price;

    private String description;

    private String imagePath;

    private String ingredient;

    private String nutrition;

    private String allergen;

    private String type;
    private List<FoodComment> foodComments;
    private List<Price> prices;
}
