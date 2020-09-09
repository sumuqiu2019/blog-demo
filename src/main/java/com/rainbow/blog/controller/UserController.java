package com.rainbow.blog.controller;

import com.rainbow.blog.commons.Resp;
import com.rainbow.blog.dto.input.LoginInfoInput;
import com.rainbow.blog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Api(tags = {"用户表"})
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Resp userLogin(@RequestBody LoginInfoInput loginInfoInput){
        return Resp.ok(userService.login(loginInfoInput));
    }

}
