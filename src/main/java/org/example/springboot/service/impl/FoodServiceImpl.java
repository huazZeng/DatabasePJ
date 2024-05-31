package org.example.springboot.service.impl;

import org.example.springboot.entity.Food;
import org.example.springboot.mapper.FoodMapper;
import org.example.springboot.mapper.OrderMapper;
import org.example.springboot.service.IFoodService;
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
 * @since 2024-05-21
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {
    private final FoodMapper Mapper;

    @Autowired
    public FoodServiceImpl(FoodMapper Mapper) {
        this.Mapper = Mapper;
    }
//    @Override
//    public List<Food> selectFoodsByCaterterId(String caterer_id) {
//        return Mapper.selectFoodsByCaterterId(caterer_id);
//    }

    @Override
    public List<Food> selectFoodsByCaterId(int caterId) {
        return Mapper.selectFoodsByCaterterId(caterId);
    }
}
