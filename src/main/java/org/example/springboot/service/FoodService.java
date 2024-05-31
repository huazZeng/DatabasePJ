package org.example.springboot.service;

import org.example.springboot.entity.Food;
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
public interface FoodService extends IService<Food> {

    List<Food> findByCatererId(int catererId);
}
