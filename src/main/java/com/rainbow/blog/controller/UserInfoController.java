package com.rainbow.blog.controller;


import com.rainbow.blog.commons.bean.Resp;
import com.rainbow.blog.commons.exception.*;
import com.rainbow.blog.service.UserInfoService;
import com.rainbow.blog.vo.LoginRespVo;
import com.rainbow.blog.vo.RegistVo;
import com.rainbow.blog.vo.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


    @PostMapping("regist")
    public Resp<String> regist(@RequestBody RegistVo registVo){
        try {
            userInfoService.regist(registVo);
        }catch (InformationLossException e){
            return Resp.fail(e.getMessage());
        }catch (UserNameExistException e){
            return Resp.fail(e.getMessage());
        }catch (PhoneExistException e){
            return Resp.fail(e.getMessage());
        }catch (MailExistException e){
            return Resp.fail(e.getMessage());
        }
        return Resp.ok(null);
    }

    @PostMapping("/login")
    public Resp<LoginRespVo> update(@RequestBody UserLoginVo userLogin) {
        LoginRespVo loginRespVo = new LoginRespVo();
        try {
            loginRespVo = userInfoService.login(userLogin);
        }catch (UserNameAndPasswordInvaildException e){
            loginRespVo.setError(e.getMessage());
            return  Resp.fail(loginRespVo);
        }
        return Resp.ok(loginRespVo);
    }
}
