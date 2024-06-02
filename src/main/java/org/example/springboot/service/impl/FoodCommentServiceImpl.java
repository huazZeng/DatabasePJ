package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.FoodComment;
import org.example.springboot.mapper.FoodCommentMapper;
import org.example.springboot.service.FoodCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class FoodCommentServiceImpl extends ServiceImpl<FoodCommentMapper, FoodComment> implements FoodCommentService {
    @Autowired
    FoodCommentMapper foodCommentMapper;
    @Override
    public List<FoodComment> findByFoodId(int foodId) {
        LambdaQueryWrapper<FoodComment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(FoodComment::getFoodId, foodId);
        return foodCommentMapper.selectList(lambdaQueryWrapper);
    }
}
