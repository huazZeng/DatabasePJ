package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Messages;
import org.example.springboot.entity.OrderFood;
import org.example.springboot.entity.Orders;
import org.example.springboot.mapper.OrderFoodMapper;
import org.example.springboot.mapper.OrdersMapper;
import org.example.springboot.service.OrderFoodService;
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
public class OrderFoodServiceImpl extends ServiceImpl<OrderFoodMapper, OrderFood> implements OrderFoodService {
    @Autowired
    OrderFoodMapper orderFoodMapper;
    @Override
    public boolean placeOrder(OrderFood orderFood) {
            return orderFoodMapper.insert(orderFood) > 0;
    }

    @Override
    public List<Integer> findFoodsByOrderId(int orderId) {
        LambdaQueryWrapper<OrderFood> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OrderFood::getOrderId, orderId);

        List<OrderFood> orderFoods= orderFoodMapper.selectList(lambdaQueryWrapper);
        List<Integer> orderFoodId=new ArrayList<>();

        for (OrderFood orderFood:orderFoods){
            orderFoodId.add(orderFood.getFoodId());
        }
        return orderFoodId;



    }
}
