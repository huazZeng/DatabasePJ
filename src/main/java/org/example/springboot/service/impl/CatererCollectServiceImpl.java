package org.example.springboot.service.impl;

import org.example.springboot.entity.CatererCollect;
import org.example.springboot.mapper.CatererCollectMapper;
import org.example.springboot.service.CatererCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CatererCollectServiceImpl extends ServiceImpl<CatererCollectMapper, CatererCollect> implements CatererCollectService {
    @Autowired
    CatererCollectMapper catererCollectMapper;
    @Override
    public boolean insert(CatererCollect catererCollect) {
        int rows = catererCollectMapper.insert(catererCollect);
        // 返回操作结果
        return rows > 0;
    }
}
