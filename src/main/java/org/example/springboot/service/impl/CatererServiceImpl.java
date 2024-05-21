package org.example.springboot.service.impl;

import org.example.springboot.entity.Caterer;
import org.example.springboot.mapper.CatererMapper;
import org.example.springboot.service.ICatererService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
@Service
public class CatererServiceImpl extends ServiceImpl<CatererMapper, Caterer> implements ICatererService {

}
