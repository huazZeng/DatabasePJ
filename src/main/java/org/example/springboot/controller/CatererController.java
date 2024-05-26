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

//    @GetMapping("/findByName")//2.c第一种实现
//    public Caterer findCatererByName(@RequestParam String name) {
//        return iService.findCaterByName(name);
//    }

    @GetMapping("/findBySearch")//2.a&b 这样返回的是全部内容。2个选择：1创建DTO对象 2前端选择性展示
    public List<Caterer> findCaterBySearch(@RequestParam String search){return iService.findCaterBySearch(search);}

    @GetMapping("/findById")//2.c
    public Caterer findCaterById(@RequestParam int id){return iService.findCaterById(id);}

}
