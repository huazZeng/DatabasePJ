package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springboot.dto.CatererBrief;
import org.example.springboot.dto.CatererDetail;
import org.example.springboot.dto.Foodanalysis;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.mapper.CatererMapper;
import org.example.springboot.mapper.FoodMapper;
import org.example.springboot.service.CatererService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springboot.service.FoodService;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
FoodMapper foodMapper;
@Autowired
FoodService foodService;
    @Override
    public List<Caterer> findCaterBySearch(String search) {
        LambdaQueryWrapper<Caterer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Caterer::getName, search);
        return catererMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<CatererBrief> findInterested(String search) {
        List<Caterer> caterers=findCaterBySearch(search);
        List<CatererBrief> catererBriefs=new ArrayList<>();
        for(Caterer caterer:caterers){
            CatererBrief catererBrief =new CatererBrief();
            catererBrief.setMainFoodName(caterer.getMainFoodName());
            catererBrief.setId(caterer.getId());
            catererBrief.setName(caterer.getName());
            catererBrief.setAddress(caterer.getAddress());
            catererBriefs.add(catererBrief);
        }
        return catererBriefs;
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
        catererDetail.setAddress(caterer.getAddress());
        catererDetail.setFoodList(foods);
        catererDetail.setMainFoodName(caterer.getMainFoodName());
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

    @Override
    public JsonResult<Caterer> login(String name, String password) {
        Caterer caterer=getByName(name);
        if (caterer==null){
            return new JsonResult<>(0,"caterer not exits");
        }
        if (!caterer.getPassword().equals(password)){
            return new JsonResult<>(0,"wrong password");
        }
        return new JsonResult<>(1,"login success",caterer);
    }


    @Override
    public Caterer getByName(String name) {
        QueryWrapper<Caterer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return catererMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean hasFood(int id, int catererId) {
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id)
                .eq("caterer_id", catererId);
        Long count = foodMapper.selectCount(queryWrapper);
        return count > 0;
    }

    @Override
    public boolean delete(int catererId) {
        int row=catererMapper.deleteById(catererId);
        return  row>0;
    }

    @Override
    public Caterer getCatererById(Integer id) {
        return catererMapper.selectById(id);
    }

    @Override
    public boolean updatecaterer(Caterer caterer) {
        Caterer currentUser = getCatererById(caterer.getId());
        if (currentUser == null) {
            // 如果找不到对应的 Food 实例，返回 false
            return false;
        }
        currentUser.setName(caterer.getName());
        currentUser.setPassword(caterer.getPassword());
        currentUser.setId(caterer.getId());
        currentUser.setMainFoodName(caterer.getMainFoodName());
        currentUser.setAddress(caterer.getAddress());
        // 保存更新后的 Food 实例到数据库
        int rows = catererMapper.updateById(currentUser);

        // 返回操作结果
        return rows > 0;
    }


}



