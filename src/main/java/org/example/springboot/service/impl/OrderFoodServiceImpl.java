package org.example.springboot.service.impl;

import org.example.springboot.entity.OrderFood;
import org.example.springboot.mapper.OrderFoodMapper;
import org.example.springboot.service.IOrderFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@Service
public class OrderFoodServiceImpl extends ServiceImpl<OrderFoodMapper, OrderFood> implements IOrderFoodService {

}
