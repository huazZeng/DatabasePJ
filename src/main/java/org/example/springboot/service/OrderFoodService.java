package org.example.springboot.service;

import org.example.springboot.entity.OrderFood;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springboot.entity.Orders;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface OrderFoodService extends IService<OrderFood> {

    boolean placeOrder(OrderFood orderFood);

    List<Integer> findFoodsByOrderId(int orderId);

    Map<Integer, Integer> findFoodsMapByOrderId(int orderId);



}
