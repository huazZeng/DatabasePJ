package org.example.springboot.controller;
import org.apache.ibatis.mapping.FetchType;
import org.example.springboot.entity.User;
import org.example.springboot.service.IUserService;
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
 * @since 2024-05-21
 */
@RestController
@RequestMapping("/springboot/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/all")
    public List<User> findall(){
        System.out.println('1');
        return  iUserService.list();
    }

    @GetMapping("/{id}")
    public JsonResult<User> getUserById(@PathVariable Long id) {
        User user = iUserService.getUserById(id);
        if (user == null) {
            return new JsonResult<>(404, "User not found");
        }
        return new JsonResult<>(200, user);
    }


}
