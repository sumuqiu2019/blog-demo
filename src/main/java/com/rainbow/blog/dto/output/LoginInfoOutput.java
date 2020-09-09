package com.rainbow.blog.dto.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 登录用户信息出参
 *
 * @author 邢晨旭
 * @date 2020/08/27
 */
@ApiModel("登录用户信息出参")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoOutput {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "签名")
    private String motto;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "登录token")
    private String token;

}
