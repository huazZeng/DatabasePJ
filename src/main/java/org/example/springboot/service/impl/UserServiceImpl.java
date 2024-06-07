package org.example.springboot.service.impl;

import org.example.springboot.entity.Food;
import org.example.springboot.entity.User;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }
    @Override
    public boolean updateuser(User user){
        User currentUser = getUserById(user.getId());
        if (currentUser == null) {
            // 如果找不到对应的 Food 实例，返回 false
            return false;
        }
        currentUser.setName(user.getName());
        currentUser.setIsStudent(user.getIsStudent());
        currentUser.setPassword(user.getPassword());
        currentUser.setId(user.getId());
        currentUser.setAge(user.getAge());
        currentUser.setGender(user.getGender());
        // 保存更新后的 Food 实例到数据库
        int rows = userMapper.updateById(currentUser);

        // 返回操作结果
        return rows > 0;
    }

    @Override
    public boolean insert(User user) {
        int rows = userMapper.insert(user);
        // 返回操作结果
        return rows > 0;
    }


}
