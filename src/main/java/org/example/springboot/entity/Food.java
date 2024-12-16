package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Getter
@Setter
@TableName("food")
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
