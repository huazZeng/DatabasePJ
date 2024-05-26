package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.User;
import org.example.springboot.mapper.CatererMapper;
import org.example.springboot.service.ICatererService;
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
 * @since 2024-05-21
 */
@Service
public class CatererServiceImpl extends ServiceImpl<CatererMapper, Caterer> implements ICatererService {
@Autowired
CatererMapper catererMapper;
//    @Override
//    public Caterer findUserByName(String name) {
//        QueryWrapper<Caterer> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", name);
//        return this.getOne(queryWrapper);
//    }

    @Override
    public Caterer findCaterById(int id) {
        QueryWrapper<Caterer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<Caterer> findCaterBySearch(String search) {
        LambdaQueryWrapper<Caterer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Caterer::getName, search);
        return catererMapper.selectList(lambdaQueryWrapper);
    }
}
