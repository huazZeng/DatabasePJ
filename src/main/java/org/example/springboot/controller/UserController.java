package org.example.springboot.controller;

import org.apache.ibatis.annotations.Update;
import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.example.springboot.utils.JsonResult;
import org.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
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
    public static final String SESSION_NAME="userInfo";


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
    @PostMapping("/root/insert")
    public boolean InsertUser(@RequestBody User user){
        boolean isInserted = userService.insert(user);
        // 返回操作结果
        return isInserted;
    }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpServletRequest request) {
        JsonResult<User> result;
        result=userService.login(id,password);
        if (result.getState()==1){
            request.getSession().setAttribute(SESSION_NAME,result.getData());
        }
        return result.getMessage();
    }

    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/is-login")
    public String isLogin(HttpServletRequest request){
        return userService.isLogin(request.getSession()).getMessage();
    }

    @PostMapping("/get-my")
    public User getMy(HttpServletRequest request){
        return (User) request.getSession().getAttribute(UserController.SESSION_NAME);
    }

}
