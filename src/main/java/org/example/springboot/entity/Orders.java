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
 * @since 2024-05-20
 */
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private LocalDateTime time;

    private String status;

    private String orderFoodId;

    private BigDecimal totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderFoodId() {
        return orderFoodId;
    }

    public void setOrderFoodId(String orderFoodId) {
        this.orderFoodId = orderFoodId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id = " + id +
            ", time = " + time +
            ", status = " + status +
            ", orderFoodId = " + orderFoodId +
            ", totalPrice = " + totalPrice +
        "}";
    }
}
