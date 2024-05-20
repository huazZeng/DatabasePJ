package org.example.springboot.service.impl;

import org.example.springboot.entity.FoodType;
import org.example.springboot.mapper.FoodTypeMapper;
import org.example.springboot.service.IFoodTypeService;
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
public class FoodTypeServiceImpl extends ServiceImpl<FoodTypeMapper, FoodType> implements IFoodTypeService {

}
