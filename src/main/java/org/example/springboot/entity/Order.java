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
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String time;

    private Long userId;

    private Long catererId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCatererId() {
        return catererId;
    }

    public void setCatererId(Long catererId) {
        this.catererId = catererId;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id = " + id +
            ", time = " + time +
            ", userId = " + userId +
            ", catererId = " + catererId +
        "}";
    }
}
