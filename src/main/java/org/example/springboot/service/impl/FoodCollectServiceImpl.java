package org.example.springboot.service.impl;

import org.example.springboot.entity.FoodCollect;
import org.example.springboot.mapper.FoodCollectMapper;
import org.example.springboot.service.FoodCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-06-11
 */
@Service
public class FoodCollectServiceImpl extends ServiceImpl<FoodCollectMapper, FoodCollect> implements FoodCollectService {

}
