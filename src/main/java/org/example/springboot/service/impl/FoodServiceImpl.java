package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springboot.dto.CatererDetail;
import org.example.springboot.dto.FoodDetail;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.FoodComment;
import org.example.springboot.entity.Price;
import org.example.springboot.mapper.FoodMapper;
import org.example.springboot.service.FoodCommentService;
import org.example.springboot.service.FoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springboot.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    FoodCommentService foodCommentService;
    @Autowired
    PriceService priceService;

    public Food findById(int id) {
        return foodMapper.selectById(id);
    }

    @Override
    public List<Food> findByCatererId(int catererId) {
        LambdaQueryWrapper<Food> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Food::getCatererId, catererId);
        return foodMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<Food> searchFoodInCaterer(Long catererId, String search) {
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("caterer_id", catererId)
                .like("name", search);
        return foodMapper.selectList(queryWrapper);
    }

    @Override
    public FoodDetail findFoodDetailById(int id) {
        Food food = findById(id);
        List<FoodComment> foodComments = foodCommentService.findByFoodId(id);
        List<Price> prices = priceService.findByFoodId(id);
        FoodDetail foodDetail = new FoodDetail();
        foodDetail.setId(food.getId());
        foodDetail.setCatererId(food.getId());
        foodDetail.setName(food.getName());
        foodDetail.setPrice(food.getPrice());
        foodDetail.setDescription(food.getDescription());
        foodDetail.setImagePath(food.getImagePath());
        foodDetail.setIngredient(food.getIngredient());
        foodDetail.setNutrition(food.getNutrition());
        foodDetail.setAllergen(food.getAllergen());
        foodDetail.setType(food.getType());
        foodDetail.setPrices(prices);
        foodDetail.setFoodComments(foodComments);
        return foodDetail;

    }
}
