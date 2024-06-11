package org.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Messages;
import org.example.springboot.mapper.FoodMapper;
import org.example.springboot.mapper.MessagesMapper;
import org.example.springboot.service.MessagesService;
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
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements MessagesService {
    @Autowired
    MessagesMapper messagesMapper;
    @Override
    public List<Messages> findMessageByUserId(int userId) {
        LambdaQueryWrapper<Messages> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Messages::getUserId, userId);

        return messagesMapper.selectList(lambdaQueryWrapper);
    }
}
