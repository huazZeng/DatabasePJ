package org.example.springboot.service;

import org.example.springboot.entity.Caterer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springboot.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-05-21
 */
public interface ICatererService extends IService<Caterer> {

//    Caterer findUserByName(String name);

    Caterer findCaterById(int id);

    List<Caterer> findCaterBySearch(String search);
}
