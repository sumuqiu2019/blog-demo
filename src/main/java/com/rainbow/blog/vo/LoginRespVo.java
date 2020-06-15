package com.rainbow.blog.vo;

import lombok.Data;

/**
 * 登录成功以后响应给前端的用户信息
 *
 * 省得以后个人信息还要再查
 */

@Data
public class LoginRespVo {

    private String userName;
    private String mail;
    private String avatarUrl;
    private String phone;
    //以上部分明文返回。

    private String error;

    //以下部分放在jwt中。

    private String token;
}
