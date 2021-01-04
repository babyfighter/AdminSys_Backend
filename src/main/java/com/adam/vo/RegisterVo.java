package com.adam.vo;

import com.adam.common.validator.group.RegisterGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class RegisterVo {
    @NotEmpty(message = "{sys.user.name.notEmpty}", groups = {RegisterGroup.class})
    @Pattern(message = "{sys.user.name.format.error}", regexp = "^.*[^\\d].*$", groups = {RegisterGroup.class})
    private String userName;
    @NotEmpty(message = "{sys.user.password.notEmpty}", groups = {RegisterGroup.class})
    private String password;
    @NotEmpty(message = "{sys.user.phone.notEmpty}", groups = {RegisterGroup.class})
    @Pattern(message = "{sys.user.phone.format.error}", regexp = "0?(13|14|15|18|17)[0-9]{9}", groups = {RegisterGroup.class})
    private String phone;
    @NotEmpty(message = "{sys.user.code.notEmpty}", groups = {RegisterGroup.class})
    private String code;
}
