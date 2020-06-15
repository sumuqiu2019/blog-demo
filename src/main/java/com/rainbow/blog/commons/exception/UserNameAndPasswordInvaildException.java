package com.rainbow.blog.commons.exception;

public class UserNameAndPasswordInvaildException extends RuntimeException {

    public UserNameAndPasswordInvaildException() {
        super("账号密码不匹配");
    }
}
