package org.example.springboot.service;

import org.example.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springboot.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public interface UserService extends IService<User> {

    User getUserById(int id);

    boolean updateuser(User user);

    boolean insert(User user);

    JsonResult<User> register(User user);

    JsonResult<User> login(String s_id, String password);

    JsonResult<User> isLogin(HttpSession session);

    User getBySid(String s_id);


}
