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
@TableName("caterer_comment")
public class CatererComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer catererId;

    private Integer userId;

    private String comment;

    private Integer grade;
}
