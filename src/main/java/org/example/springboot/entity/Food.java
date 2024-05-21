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
 * @since 2024-05-21
 */
@TableName("food")
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String catererId;

    private String name;

    private BigDecimal price;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatererId() {
        return catererId;
    }

    public void setCatererId(String catererId) {
        this.catererId = catererId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" +
            "id = " + id +
            ", catererId = " + catererId +
            ", name = " + name +
            ", price = " + price +
            ", description = " + description +
        "}";
    }
}
