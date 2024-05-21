package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
@TableName("order_food")
public class OrderFood implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Long foodId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
            "orderId = " + orderId +
            ", foodId = " + foodId +
        "}";
    }
}
