package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.dto.CatererDetail;
import org.example.springboot.dto.Foodanalysis;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.mapper.CatererMapper;
import org.example.springboot.service.CatererService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springboot.service.FoodService;
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
@Autowired
FoodService foodService;
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

    @Override
    public CatererDetail findCaterDetailById(int id) {
        Caterer caterer=catererMapper.selectById(id);
        List<Food>foods=foodService.findByCatererId(id);
        CatererDetail catererDetail=new CatererDetail();
        catererDetail.setId(caterer.getId());
        catererDetail.setName(caterer.getName());
        catererDetail.setPassword(catererDetail.getPassword());
        catererDetail.setAddress(caterer.getAddress());
        catererDetail.setFoodList(foods);
        catererDetail.setMainFoodId(caterer.getMainFoodId());
        return catererDetail;
    }

    @Override
    public boolean insert(Caterer caterer) {
        int rows = catererMapper.insert(caterer);
        // 返回操作结果
        return rows > 0;
    }

    @Override
    public List<Foodanalysis> getAnalysis(int id) {
        return catererMapper.getAnalysis(id);
        
    }


}
