package com.adam.vo;

import com.adam.common.validator.group.LoginGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NamePwdLoginVo {
    @NotEmpty(message = "{sys.user.name.notEmpty}", groups = {LoginGroup.class})
    private String userName;
    @NotEmpty(message = "{sys.user.password.notEmpty}", groups = {LoginGroup.class})
    private String password;
}