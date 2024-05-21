package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
@TableName("price")
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    private String foodId;

    private LocalDateTime time;

    private BigDecimal price;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
            "foodId = " + foodId +
            ", time = " + time +
            ", price = " + price +
        "}";
    }
}
