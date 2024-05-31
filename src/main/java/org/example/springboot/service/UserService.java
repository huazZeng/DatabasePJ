package org.example.springboot.service;

import org.example.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface UserService extends IService<User> {

    User getUserById(int id);
}
