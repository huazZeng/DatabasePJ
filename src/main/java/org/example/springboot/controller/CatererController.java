package org.example.springboot.controller;

import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.User;
import org.example.springboot.service.ICatererService;
import org.example.springboot.service.IFoodService;
import org.example.springboot.service.IUserService;
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
@RequestMapping("/springboot/caterer")
public class CatererController {
    @Autowired
    ICatererService iService;
    @GetMapping("/all")
    public List<Caterer> findall(){
        System.out.println('1');
        return  iService.list();
    }
}
