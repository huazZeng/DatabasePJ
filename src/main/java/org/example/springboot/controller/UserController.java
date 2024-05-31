package org.example.springboot.controller;

import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/{id}")//1.a
//    public JsonResult<User> getUserById(@PathVariable Long id) {
//        User user = UserService.getUserById(id);
//        if (user == null) {
//            return new JsonResult<>(404, "User not found");
//        }
//        return new JsonResult<>(200, user);
//    }


}
