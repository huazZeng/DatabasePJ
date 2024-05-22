package org.example.springboot.controller;

import org.example.springboot.entity.Order;
import org.example.springboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/springboot/order")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable("userId") String userId) {
        return orderService.selectorderByuserId(userId);
    }
}
