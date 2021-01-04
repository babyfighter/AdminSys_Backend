package com.adam.vo;


import com.adam.common.validator.group.LoginGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 登录时的视图数据类（view object），
 * 用于接收使用 手机号 + 密码 登陆的数据与操作。
 */
@Data
public class PhonePwdLoginVo {
    @NotEmpty(message = "{sys.user.phone.notEmpty}", groups = {LoginGroup.class})
    @Pattern(message = "{sys.user.phone.format.error}", regexp = "0?(13|14|15|18|17)[0-9]{9}", groups = {LoginGroup.class})
    private String phone;
    @NotEmpty(message = "{sys.user.password.notEmpty}", groups = {LoginGroup.class})
    private String password;
}