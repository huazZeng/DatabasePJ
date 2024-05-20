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
@TableName("collect")
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String catererId;

    private String foodId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "Collect{" +
            "userId = " + userId +
            ", catererId = " + catererId +
            ", foodId = " + foodId +
        "}";
    }
}