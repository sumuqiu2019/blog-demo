package com.rainbow.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbow.blog.dto.input.LoginInfoInput;
import com.rainbow.blog.dto.output.LoginInfoOutput;
import com.rainbow.blog.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
public interface UserService extends IService<User> {


    /**
     * 用户登录
     * @param loginInfoInput
     * @return
     */
    User login(LoginInfoInput loginInfoInput);
}
