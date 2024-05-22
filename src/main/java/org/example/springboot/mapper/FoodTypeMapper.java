package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.FoodType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
public interface FoodTypeMapper extends BaseMapper<FoodType> {

}
