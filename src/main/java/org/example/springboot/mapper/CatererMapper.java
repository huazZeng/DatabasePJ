package org.example.springboot.mapper;

import org.example.springboot.dto.Foodanalysis;
import org.example.springboot.entity.Caterer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
public interface CatererMapper extends BaseMapper<Caterer> {
    List<Foodanalysis> getAnalysis(Integer caterer_id);

}
