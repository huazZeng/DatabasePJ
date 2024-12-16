package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT MAX(id) FROM orders")
    int selectMaxId();


}
