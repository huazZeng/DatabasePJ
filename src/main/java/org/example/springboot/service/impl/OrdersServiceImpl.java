package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.dto.OrderDetail;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Orders;
import org.example.springboot.mapper.OrderFoodMapper;
import org.example.springboot.mapper.OrdersMapper;
import org.example.springboot.service.OrderFoodService;
import org.example.springboot.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrderFoodService orderFoodService;

    @Override
    public boolean placeOrder(Orders orders) {
        return ordersMapper.insert(orders) > 0;
    }

    @Override
    public List<Orders> findOrdersByUserId(int userId) {
        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Orders::getUserId, userId);
        return ordersMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public int getInsertId() {
        return ordersMapper.selectMaxId();
    }

    @Override
    public List<OrderDetail> findDetailOrdersByUserId(int myId) {
        List<Orders> orders=findOrdersByUserId(myId);

        List<OrderDetail> orderDetails=new ArrayList<>();
        for(Orders orders1:orders){
            OrderDetail orderDetail=new OrderDetail();

            orderDetail.setId(orders1.getId());
            orderDetail.setIsQueueOrder(orders1.getIsQueueOrder());
            orderDetail.setIsFinished(orders1.getIsFinished());
            orderDetail.setTime(orders1.getTime());
            orderDetail.setCatererId(orders1.getCatererId());
            orderDetail.setFoods(orderFoodService.findFoodsByOrderId(orders1.getId()));

            orderDetails.add(orderDetail);

        }


        return orderDetails;
    }
}
