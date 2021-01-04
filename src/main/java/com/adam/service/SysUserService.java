package com.adam.service;

import com.adam.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author Adam
 * @since 2020-12-22
 */
public interface SysUserService extends IService<SysUser> {
    public boolean saveUser(SysUser sysUser);
}
