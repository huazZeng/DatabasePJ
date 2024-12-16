package org.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("food_comment")
public class FoodComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer foodId;

    private Integer userId;

    private String comment;

    private Integer grade;
}
