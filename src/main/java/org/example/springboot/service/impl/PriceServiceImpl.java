package org.example.springboot.service.impl;

import org.example.springboot.entity.Price;
import org.example.springboot.mapper.PriceMapper;
import org.example.springboot.service.IPriceService;
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
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price> implements IPriceService {

}
