package com.rainbow.blog.service.impl;

import com.rainbow.blog.entity.User;
import com.rainbow.blog.mapper.UserMapper;
import com.rainbow.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.Query;
import com.rainbow.blog.commons.bean.QueryCondition;
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

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<User> page = this.page(
            new Query<User>().getPage(params),
            new QueryWrapper<User>());
            return new PageVo(page);
    }

}

