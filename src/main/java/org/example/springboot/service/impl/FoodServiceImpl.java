package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.mapper.FoodMapper;
import org.example.springboot.service.FoodService;
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
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
@Autowired
FoodMapper foodMapper;

    @Override
    public List<Food> findByCatererId(int catererId) {
        LambdaQueryWrapper<Food> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Food::getCatererId, catererId);
        return foodMapper.selectList(lambdaQueryWrapper);
    }
}
