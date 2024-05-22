package org.example.springboot.service;

import org.apache.ibatis.annotations.Param;
import org.example.springboot.entity.Food;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
public interface IFoodService extends IService<Food> {
    List<Food> selectFoodsByCaterterId(@Param("caterterid") String caterterid);
}
