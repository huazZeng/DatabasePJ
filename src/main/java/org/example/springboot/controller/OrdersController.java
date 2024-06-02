package org.example.springboot.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Orders;
import org.example.springboot.service.OrderFoodService;
import org.example.springboot.service.OrdersService;
import org.example.springboot.utils.JsonResult;
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
@RequestMapping("/springboot/orders")
public class OrdersController {

        @Autowired
        OrdersService ordersService;

    @PostMapping("/placeOrder")//下单成功，并验证了触发器也实现正确
    public JsonResult<String> placeOrder(@RequestBody Orders orders){
        boolean success = ordersService.placeOrder(orders);
        if (success) return new JsonResult<>(1,"place success!");
        else return new JsonResult<>(0,"place failed!");
    }

    @GetMapping("/findByUserId")
    public List<Orders> findOrdersByUserId(@RequestParam int userId){return ordersService.findOrdersByUserId(userId);}

}
