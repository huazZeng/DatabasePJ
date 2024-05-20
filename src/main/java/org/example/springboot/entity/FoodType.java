package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@TableName("food_type")
public class FoodType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String catererId;

    private String foodId;

    private String type;

    public String getCatererId() {
        return catererId;
    }

    public void setCatererId(String catererId) {
        this.catererId = catererId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FoodType{" +
            "catererId = " + catererId +
            ", foodId = " + foodId +
            ", type = " + type +
        "}";
    }
}
