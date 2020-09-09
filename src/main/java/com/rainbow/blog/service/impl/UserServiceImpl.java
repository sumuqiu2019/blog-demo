package com.rainbow.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbow.blog.aop.exception.MyException;
import com.rainbow.blog.dto.input.LoginInfoInput;
import com.rainbow.blog.dto.output.LoginInfoOutput;
import com.rainbow.blog.entity.User;
import com.rainbow.blog.mapper.UserMapper;
import com.rainbow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(LoginInfoInput loginInfoInput) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getUsername,loginInfoInput.getAccount());
        wrapper.eq(User::getPassword,loginInfoInput.getPassword());
        User user = userMapper.selectOne(wrapper);
        if(user==null){
            throw new MyException("账号密码错误");
        }
        user.setPassword("");
        return user;
    }
}

