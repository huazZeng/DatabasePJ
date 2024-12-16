package org.example.springboot.controller;

import org.example.springboot.dto.CatererDetail;
import org.example.springboot.dto.FoodDetail;
import org.example.springboot.entity.Food;
import org.example.springboot.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/food")
public class FoodController {
@Autowired
    FoodService foodService;

    @GetMapping("/findByCatererId")
    public List<Food> findByCatererId(@RequestParam int catererId){
        return foodService.findByCatererId(catererId);
    }

    @GetMapping("/searchInterestedFoodsInCaterer")//4.a
    public List<Food> searchFoodInCaterer(@RequestParam Long catererId, @RequestParam String search) {
        return foodService.searchFoodInCaterer(catererId, search);
    }

    @GetMapping("/findDetailById")
    public FoodDetail findFoodDetailById(@RequestParam int id){return foodService.findFoodDetailById(id);}

    @PostMapping("/updateprice")
    public boolean updateFoodPrice(@RequestBody Food food){
        return foodService.updateFoodPrice(food);
    }

    @PostMapping("/deleteFood")
    public boolean deleteFood(@RequestBody Food food){
        return foodService.deleteFood(food);
    }
    @PostMapping("/updateFoodtype")
    public boolean updateFoodtype(@RequestBody Food food){
        return foodService.updateFoodType(food);
    }
}
