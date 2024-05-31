package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Caterer;
import org.example.springboot.mapper.CatererMapper;
import org.example.springboot.service.CatererService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class CatererServiceImpl extends ServiceImpl<CatererMapper, Caterer> implements CatererService {
@Autowired
CatererMapper catererMapper;
    @Override
    public List<Caterer> findCaterBySearch(String search) {
        LambdaQueryWrapper<Caterer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Caterer::getName, search);
        return catererMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public Caterer findCaterById(int id) {
        return catererMapper.selectById(id);
    }
}
