package org.example.springboot.service;

import org.example.springboot.entity.Price;
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
public interface PriceService extends IService<Price> {

    List<Price> findByFoodId(int foodId);
}
