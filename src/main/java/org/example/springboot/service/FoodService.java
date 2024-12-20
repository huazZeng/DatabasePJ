package org.example.springboot.service;

import org.example.springboot.dto.CollectAnalysis;
import org.example.springboot.dto.FoodDetail;
import org.example.springboot.entity.Food;
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
public interface FoodService extends IService<Food> {

    List<Food> findByCatererId(int catererId);

    List<Food> searchFoodInCaterer(Long catererId, String search);

    FoodDetail findFoodDetailById(int id);


    boolean updateFoodPrice(Food food);

    boolean deleteFood(Food food);

    boolean updateFoodType(Food food);

    boolean insertFood(Food food);
}
