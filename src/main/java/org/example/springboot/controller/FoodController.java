package org.example.springboot.controller;

import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Order;
import org.example.springboot.service.IFoodService;
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
 * @since 2024-05-21
 */
@RestController
@RequestMapping("/springboot/food")
public class FoodController {
    @Autowired
    IFoodService iFoodService;
    @GetMapping("/menu/{cId}")
    public List<Food> getUserOrders(@PathVariable("cId") int cID) {

        return iFoodService.selectFoodsByCaterId(cID);
    }

    @GetMapping("/findByCaterId")
    public List<Food> findFoodByCaterId(@RequestParam int CaterId ){return iFoodService.selectFoodsByCaterId(CaterId);}

//    @GetMapping("/findByCaterId")
//    public List<Food> findFoodByCaterId(){return iFoodService.selectFoodsByCaterterId()}
}
