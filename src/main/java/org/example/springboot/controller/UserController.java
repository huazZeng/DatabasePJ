package org.example.springboot.controller;

import org.apache.ibatis.annotations.Update;
import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public List<User> findAll(){
        return  userService.list();
    }

    @GetMapping("/{id}")//1.a
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping("/update")
    public boolean UpdateUser(@RequestBody User user){
        User currentUser = userService.getUserById(user.getId());
        if (currentUser == null) {
            // 如果找不到对应的用户，返回 false
            return false;
        }

        // 更新用户信息
        boolean isUpdated = userService.updateuser(user);
        // 返回操作结果
        return isUpdated;
    }
    @PostMapping("/insert")
    public boolean InsertUser(@RequestBody User user){
        boolean isInserted = userService.insert(user);
        // 返回操作结果
        return isInserted;
    }
}
