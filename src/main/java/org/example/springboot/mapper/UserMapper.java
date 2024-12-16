package org.example.springboot.mapper;

import org.example.springboot.dto.CollectAnalysis;
import org.example.springboot.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

    List<CollectAnalysis> getCollectAnalysis(Integer id);
}
