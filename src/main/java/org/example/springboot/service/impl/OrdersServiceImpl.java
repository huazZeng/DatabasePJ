package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Orders;
import org.example.springboot.mapper.OrdersMapper;
import org.example.springboot.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
