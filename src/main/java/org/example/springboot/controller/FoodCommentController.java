package org.example.springboot.controller;

import org.example.springboot.entity.CatererComment;
import org.example.springboot.entity.FoodComment;
import org.example.springboot.service.FoodCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/foodComment")
public class FoodCommentController {
    @Autowired
    FoodCommentService foodCommentService;
    @PostMapping("InsertComment")
    public boolean InsertComment(@RequestBody FoodComment comment){
        boolean isInserted = foodCommentService.insert(comment);
        // 返回操作结果
        return isInserted;
    }



}
