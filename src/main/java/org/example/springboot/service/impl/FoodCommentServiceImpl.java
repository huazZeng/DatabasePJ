package org.example.springboot.service.impl;

import org.example.springboot.entity.FoodComment;
import org.example.springboot.mapper.FoodCommentMapper;
import org.example.springboot.service.FoodCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class FoodCommentServiceImpl extends ServiceImpl<FoodCommentMapper, FoodComment> implements FoodCommentService {

}
