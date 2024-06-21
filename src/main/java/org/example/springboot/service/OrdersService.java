package org.example.springboot.service;

import org.example.springboot.dto.OrderDetail;
import org.example.springboot.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface OrdersService extends IService<Orders> {

    boolean placeOrder(Orders orders);

    List<Orders> findOrdersByUserId(int userId);

    int getInsertId();

    List<OrderDetail> findDetailOrdersByUserId(int myId);
}
