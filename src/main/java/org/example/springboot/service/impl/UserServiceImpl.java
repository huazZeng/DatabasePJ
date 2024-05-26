package org.example.springboot.service.impl;

import org.example.springboot.entity.User;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
