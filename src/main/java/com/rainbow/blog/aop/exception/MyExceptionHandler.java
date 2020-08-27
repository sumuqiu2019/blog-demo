package com.rainbow.blog.aop.exception;

import com.rainbow.blog.commons.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author 邢晨旭
 * @date 2020/08/27
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(value=MyException.class)
    public Resp handleMyException(MyException e) {
        log.error("自定义异常:{}", e.toString());
        return Resp.fail().msg(e.getMsg()).code(e.getCode());
    }

    @ExceptionHandler(value=Exception.class)
    public Resp handleException(Exception e, HttpServletRequest request) {
        log.error("msg:{},url:{}", e.getMessage(), request.getRequestURL());
        return Resp.fail().msg(e.getMessage());
    }
}
