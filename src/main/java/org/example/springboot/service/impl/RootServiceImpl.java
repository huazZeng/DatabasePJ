package org.example.springboot.service.impl;

import org.example.springboot.entity.Root;
import org.example.springboot.mapper.RootMapper;
import org.example.springboot.service.IRootService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-20
 */
@Service
public class RootServiceImpl extends ServiceImpl<RootMapper, Root> implements IRootService {

}
