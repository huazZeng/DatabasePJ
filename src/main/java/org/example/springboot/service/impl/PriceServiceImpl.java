package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Price;
import org.example.springboot.mapper.PriceMapper;
import org.example.springboot.service.PriceService;
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
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price> implements PriceService {
    @Autowired
    PriceMapper priceMapper;
    @Override
    public List<Price> findByFoodId(int foodId) {
        LambdaQueryWrapper<Price> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Price::getFoodId, foodId);
        return priceMapper.selectList(lambdaQueryWrapper);
    }
}
