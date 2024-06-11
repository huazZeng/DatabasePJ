package org.example.springboot.service;

import org.example.springboot.entity.FoodCollect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-06-11
 */
public interface FoodCollectService extends IService<FoodCollect> {

    boolean insert(FoodCollect foodCollect);
}
