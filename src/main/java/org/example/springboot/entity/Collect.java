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
@TableName("collect")
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer foodId;
}
