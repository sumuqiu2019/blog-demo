package com.rainbow.blog.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 用户登录入参
 *
 * @author 邢晨旭
 * @date 2020/08/27
 */
@ApiModel("用户登录入参")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoInput {

    @ApiModelProperty("登陆账号")
    private String account;

    @ApiModelProperty("登陆密码")
    private String password;

}
