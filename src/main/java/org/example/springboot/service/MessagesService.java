package org.example.springboot.service;

import org.example.springboot.entity.Messages;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface MessagesService extends IService<Messages> {

    List<Messages> findMessageByUserId(int userId);
}
