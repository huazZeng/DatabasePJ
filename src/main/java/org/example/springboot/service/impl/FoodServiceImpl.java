package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springboot.dto.FoodDetail;
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
    @Override
    public boolean updateFoodPrice(Food food){
        Food currentFood = findById(food.getId());
        if (currentFood == null) {
            // 如果找不到对应的 Food 实例，返回 false
            return false;
        }
        // 更新价格
        currentFood.setPrice(food.getPrice());

        // 保存更新后的 Food 实例到数据库
        int rows = foodMapper.updateById(currentFood);

        // 返回操作结果
        return rows > 0;
    }
    @Override
    public boolean deleteFood(Food food){
            // 从数据库中查找当前的 Food 实例
            Food currentFood = findById(food.getId());
            if (currentFood == null) {
                // 如果找不到对应的 Food 实例，返回 false
                return false;
            }
            return  true;
//            // 删除与该 Food 实例相关的评论
//            boolean commentsDeleted = foodCommentService.deleteByFoodId(food.getId());
//            if (!commentsDeleted) {
//                // 如果删除评论失败，返回 false
//                return false;
//            }
//
//            // 删除与该 Food 实例相关的价格信息
//            boolean pricesDeleted = priceService.deleteByFoodId(food.getId());
//            if (!pricesDeleted) {
//                // 如果删除价格信息失败，返回 false
//                return false;
//            }
//
//            // 删除 Food 实例
//            int rows = foodMapper.deleteById(food.getId());

            // 返回操作结果
//            return rows > 0;

    }
    @Override
    public boolean updateFoodType(Food food){
        Food currentFood = findById(food.getId());
        if (currentFood == null) {
            // 如果找不到对应的 Food 实例，返回 false
            return false;
        }
        // 更新价格
        currentFood.setType(food.getType());

        // 保存更新后的 Food 实例到数据库
        int rows = foodMapper.updateById(currentFood);

        // 返回操作结果
        return rows > 0;
    }

    @Override
    public boolean insertFood(Food food) {

        return foodMapper.insert(food)>0;
    }

}
