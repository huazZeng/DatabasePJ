package org.example.springboot.controller;

import org.example.springboot.entity.FoodCollect;
import org.example.springboot.service.FoodCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-06-11
 */
@RestController
@RequestMapping("/springboot/foodCollect")
public class FoodCollectController {
    @Autowired
    FoodCollectService foodCollectService;
    @RequestMapping("/insert")
    public boolean insert(@RequestBody FoodCollect foodCollect){
       return foodCollectService.insert(foodCollect);
    }
}
