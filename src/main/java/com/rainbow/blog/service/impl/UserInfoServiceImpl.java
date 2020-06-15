package com.rainbow.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbow.blog.commons.exception.*;
import com.rainbow.blog.commons.utils.DateUtils;
import com.rainbow.blog.commons.utils.JwtUtils;
import com.rainbow.blog.entity.UserInfo;
import com.rainbow.blog.mapper.UserInfoDao;
import com.rainbow.blog.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbow.blog.vo.LoginRespVo;
import com.rainbow.blog.vo.RegistVo;
import com.rainbow.blog.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-06-12
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public LoginRespVo login(UserLoginVo userLogin) throws UserNameAndPasswordInvaildException {

        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>()
                .or().eq("user_name", userLogin.getLoginacct())
                .or().eq("phone", userLogin.getLoginacct())
                .or().eq("mail", userLogin.getLoginacct());

        UserInfo userInfo = userInfoDao.selectOne(wrapper);
        if(userInfo == null){
            //登录失败
            throw new UserNameAndPasswordInvaildException();
        }
        //验证密码

        boolean matches = new BCryptPasswordEncoder().matches(userLogin.getPassword(), userInfo.getPassword());
            //登陆成功
            if(matches){
                //生成token
                String token = UUID.randomUUID().toString().replace("-", "");
                LoginRespVo loginRespVo = new LoginRespVo();
                Map<String,Object> map = new HashMap<>();
                map.put("token",token);
                map.put("id",userInfo.getUserId());
                map.put("name",userInfo.getUserName());
                //将我们在redis中的token做成jwt返回过去
                String jwt = JwtUtils.buildJwt(map, null);
                loginRespVo.setToken(jwt);
                BeanUtils.copyProperties(userInfo,loginRespVo);
                log.info("用户{}于{}执行了登陆操作",userInfo.getUserName(), DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
                return loginRespVo;
        }else{
            throw new UserNameAndPasswordInvaildException();
        }

    }

    @Override
    public void regist(RegistVo registVo) throws InformationLossException,UserNameExistException, MailExistException,PhoneExistException {
        UserInfo userInfo = new UserInfo();

        if("".equals(registVo.getUserName())||"".equals(registVo.getPhone())
                ||"".equals(registVo.getMail())||"".equals(registVo.getPassword())){
            throw new InformationLossException();
        }


        Integer username = userInfoDao.selectCount(new QueryWrapper<UserInfo>().eq("user_name", registVo.getUserName()));
        //
        if (username > 0) {
            throw new UserNameExistException();
        }

        Integer email = userInfoDao.selectCount(new QueryWrapper<UserInfo>().eq("mail", registVo.getMail()));
        if (email > 0) {
            throw new MailExistException();
        }

        Integer mobile = userInfoDao.selectCount(new QueryWrapper<UserInfo>().eq("phone", registVo.getPhone()));
        if (mobile > 0) {
            throw new PhoneExistException();
        }


        BeanUtils.copyProperties(registVo,userInfo);
        userInfo.setPassword(new BCryptPasswordEncoder().encode(registVo.getPassword()));
        this.save(userInfo);
    }

    /*MemberEntity entity = new MemberEntity();

    //entity设置其他字段的默认，生成的永远是不一样的
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    String encode = encoder.encode(vo.getPassword());


        entity.setUsername(vo.getUsername());
        entity.setPassword(encode);
        entity.setEmail(vo.getEmail());
        entity.setMobile(vo.getPhone());


    Integer username = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("username", vo.getUsername()));
    //
        if (username > 0) {
        throw new UsernameExistException();
    }

    Integer email = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("email", vo.getEmail()));
        if (email > 0) {
        throw new EmailExistException();
    }

    Integer mobile = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("mobile", vo.getPhone()));
        if (mobile > 0) {
        throw new PhoneExistException();
    }

    //

        memberDao.insert(entity);*/
}
