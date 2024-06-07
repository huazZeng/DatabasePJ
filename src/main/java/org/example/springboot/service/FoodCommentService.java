package org.example.springboot.service;

import org.example.springboot.entity.FoodComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface FoodCommentService extends IService<FoodComment> {

    public List<FoodComment> findByFoodId(int foodId);

    boolean insert(FoodComment comment);
}
