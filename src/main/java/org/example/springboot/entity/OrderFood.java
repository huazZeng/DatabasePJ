package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@TableName("order_food")
public class OrderFood implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    private String catererId;

    private String foodId;

    private BigDecimal realPrice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
            "orderId = " + orderId +
            ", catererId = " + catererId +
            ", foodId = " + foodId +
            ", realPrice = " + realPrice +
        "}";
    }
}
