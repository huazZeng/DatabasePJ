package org.example.springboot.service;

import org.example.springboot.entity.CatererCollect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2024-06-11
 */
public interface CatererCollectService extends IService<CatererCollect> {

    boolean insert(CatererCollect catererCollect);
}
