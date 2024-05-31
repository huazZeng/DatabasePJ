package org.example.springboot.controller;

import org.example.springboot.entity.Caterer;
import org.example.springboot.service.CatererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/springboot/caterer")
public class CatererController {
@Autowired
    CatererService catererService;
    @GetMapping("/findBySearch")//2.a&b 这样返回的是全部内容。2个选择：1创建DTO对象 2前端选择性展示
    public List<Caterer> findCaterBySearch(@RequestParam String search){return catererService.findCaterBySearch(search);}

    @GetMapping("/findById")//2.c 3.a查询一个商户的所有信息，包括菜单、菜品概要等,1创建DTO对象 2一个页面同时发送两个请求请求cater信息同时请求对应的菜品
    public Caterer findCaterById(@RequestParam int id){return catererService.findCaterById(id);}
}
