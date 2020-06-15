package com.rainbow.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserInfo对象", description = "")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户唯一id")
    private Integer userId;

    @ApiModelProperty(value = "用户名（唯一可用于登录）")
    private String userName;

    @ApiModelProperty(value = "用户头像地址")
    private String avatarUrl;

    @ApiModelProperty(value = "手机号（可用于登录）")
    private String phone;

    @ApiModelProperty(value = "邮箱（可用于登录--订阅消息推送）")
    private String mail;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;


}
