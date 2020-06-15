package com.rainbow.blog.service;

import com.rainbow.blog.commons.exception.InformationLossException;
import com.rainbow.blog.commons.exception.UserNameAndPasswordInvaildException;
import com.rainbow.blog.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbow.blog.vo.LoginRespVo;
import com.rainbow.blog.vo.RegistVo;
import com.rainbow.blog.vo.UserLoginVo;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-06-12
 */
public interface UserInfoService extends IService<UserInfo> {

    LoginRespVo login(UserLoginVo userLogin) throws UserNameAndPasswordInvaildException;

    void regist(RegistVo registVo) throws InformationLossException;
}
