package com.rainbow.blog.service;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import com.rainbow.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
public interface UserService extends IService<User> {

    PageVo queryPage(QueryCondition params);

}
