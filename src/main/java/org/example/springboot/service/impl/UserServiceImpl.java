package org.example.springboot.service.impl;


import org.example.springboot.dto.CollectAnalysis;
import org.example.springboot.entity.Food;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springboot.controller.UserController;

import org.example.springboot.entity.User;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Component
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
        currentUser.setType(user.getType());
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




    @Override
    public JsonResult<User> register(User user) {
        User getUser =getBySid(user.getSId());
        if (getUser!=null){
            return new JsonResult<User>(0,"user exists");
        }
        userMapper.insert(user);
        return new JsonResult<User>(1,"register succeeded");
    }

    @Override
    public JsonResult<User> login(String s_id, String password) {
        User user=getBySid(s_id);
        if (user==null){
            return new JsonResult<>(0,"user not exits");
        }
        if (!user.getPassword().equals(password)){
            return new JsonResult<>(0,"wrong password");
        }
        return new JsonResult<>(1,"login success",user);
    }

    @Override
    public JsonResult<User> isLogin(HttpSession session) {
        User settionUser=(User) session.getAttribute(UserController.SESSION_NAME);
        if (settionUser==null){
            return new JsonResult<>(0,"user not log in");
        }
        User getUser=getBySid(settionUser.getSId());
        if (getUser==null||!getUser.getPassword().equals(settionUser.getPassword())){
            return new JsonResult<>(0,"user info not valid");
        }
        return new JsonResult<>(1,"logged in",getUser);
    }

    @Override
    public User getBySid(String s_id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_id", s_id);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public List<CollectAnalysis> getCollectAnalysis(Integer id) {
        return userMapper.getCollectAnalysis(id);
    }

    @Override
    public boolean delete(int userid) {
        User user=userMapper.selectById(userid);
        if (user.getType().equals("root")) {
            return  false;
        }
        int row = userMapper.deleteById(userid);
        return row>0;
    }

}
