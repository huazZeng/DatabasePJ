package org.example.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    IPage<Orders>findOrdersByCatererId(int catererId,int pageNumber, int pageSize);

    int getInsertId();

    List<OrderDetail> findDetailOrdersByUserId(int myId);

    boolean complecterId(int orderId);

    IPage<Orders> getOrdersByPage(int pageNumber, int pageSize);

    OrderDetail findDetailById(int id);
}
