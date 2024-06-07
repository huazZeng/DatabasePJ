package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.CatererComment;
import org.example.springboot.mapper.CatererCommentMapper;
import org.example.springboot.service.CatererCommentService;
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
public class CatererCommentServiceImpl extends ServiceImpl<CatererCommentMapper, CatererComment> implements CatererCommentService {
    @Autowired
    CatererCommentMapper catererCommentMapper;

    @Override
    public List<CatererComment> findCatererCommentByCatererId(int catererId) {
        LambdaQueryWrapper<CatererComment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CatererComment::getCatererId, catererId);
        return catererCommentMapper.selectList(lambdaQueryWrapper);
    }
    @Override
    public boolean insert(CatererComment comment){
        int rows = catererCommentMapper.insert(comment);
        // 返回操作结果
        return rows > 0;
    }
}
