package org.example.springboot.service;

import org.example.springboot.entity.Caterer;
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
public interface CatererService extends IService<Caterer> {

    List<Caterer> findCaterBySearch(String search);

    Caterer findCaterById(int id);
}