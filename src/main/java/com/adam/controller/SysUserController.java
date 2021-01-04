package com.adam.controller;


import com.adam.common.utils.*;
import com.adam.common.validator.group.LoginGroup;
import com.adam.common.validator.group.RegisterGroup;
import com.adam.entity.SysUser;
import com.adam.service.SysUserService;
import com.adam.vo.JwtVo;
import com.adam.vo.NamePwdLoginVo;
import com.adam.vo.PhonePwdLoginVo;
import com.adam.vo.RegisterVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author Adam
 * @since 2020-12-22
 */

@RestController
@RequestMapping("/sys/sys-user")
@Api(tags = "用户登录、注册操作")
public class SysUserController {

        /**
         * 用于操作 sys_user 表
         */
        @Autowired
        private SysUserService sysUserService;
        /**
         * 用于操作 redis
         */
        @Autowired
        private RedisUtil redisUtil;

        @ApiOperation(value = "用户注册")
        @PostMapping("/register")
        public Result register(@Validated({RegisterGroup.class}) @RequestBody RegisterVo registerVo) {
            if (save(registerVo)) {
                return Result.ok().message("用户注册成功");
            }
            return Result.error().message("用户注册失败");
        }

        /**
         * 真实注册操作
         * @param registerVo 注册数据
         * @return true 为插入成功， false 为失败
         */
        public boolean save(RegisterVo registerVo) {
            // 判断 redis 中是否存在 验证码
            String code = redisUtil.get(registerVo.getPhone());
            // redis 中存在验证码且与当前验证码相同
            if (StringUtils.isNotEmpty(code) && code.equals(registerVo.getCode())) {
                SysUser sysUser = new SysUser();
                sysUser.setName(registerVo.getUserName()).setPassword(MD5Util.encrypt(registerVo.getPassword()));
                sysUser.setMobile(registerVo.getPhone());
                return sysUserService.saveUser(sysUser);
            }
            return false;
        }
}

