package org.example.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.springboot.dto.OrderDetail;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.OrderFood;
import org.example.springboot.entity.Orders;
import org.example.springboot.entity.User;
import org.example.springboot.service.OrderFoodService;
import org.example.springboot.service.OrdersService;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
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

        @Autowired
        OrderFoodService orderFoodService;

    @Transactional
    @PostMapping("/placeOrder")//下单成功，并验证了触发器也实现正确
    public JsonResult<String> placeOrder(HttpServletRequest request,@RequestParam int catererId,@RequestParam boolean isQueueOrder,@RequestBody List<Integer> orderFoods){
        Orders orders=new Orders();
        User user=(User) request.getSession().getAttribute(UserController.SESSION_NAME);
        int insertId=ordersService.getInsertId();
        insertId++;

        orders.setUserId(user.getId());
        orders.setIsQueueOrder(isQueueOrder);
        orders.setTime(LocalDateTime.now());
        orders.setIsFinished(false);
        orders.setCatererId(catererId);
        orders.setId(insertId);

        boolean success = ordersService.placeOrder(orders);



        for(int i:orderFoods){
            OrderFood orderFood=new OrderFood();
            orderFood.setOrderId(insertId);
            orderFood.setFoodId(i);
            orderFoodService.placeOrder(orderFood);
        }

        if (success) return new JsonResult<>(1,"place success!");
        else return new JsonResult<>(0,"place failed!");
    }


    @GetMapping("/find-my")
    public List<OrderDetail> findMy(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute(UserController.SESSION_NAME);
        int my_id = user.getId();
        return ordersService.findDetailOrdersByUserId(my_id);
    }

    @GetMapping("/findByUserId")
    public List<Orders> findOrdersByUserId(@RequestParam int userId){return ordersService.findOrdersByUserId(userId);}


    @GetMapping("/getOrdersByPage")
    public IPage<Orders> getUsersByPage(
            @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        return ordersService.getOrdersByPage(pageNumber, pageSize);
    }

}
