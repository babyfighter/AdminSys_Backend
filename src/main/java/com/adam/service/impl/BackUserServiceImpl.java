package com.adam.service.impl;

import com.adam.entity.BackUser;
import com.adam.mapper.BackUserMapper;
import com.adam.service.BackUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Adam
 * @since 2020-12-21
 */
@Service
public class BackUserServiceImpl extends ServiceImpl<BackUserMapper, BackUser> implements BackUserService {

}
