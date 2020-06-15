package com.rainbow.blog.commons.exception;

public class UserNameExistException extends RuntimeException {

    public UserNameExistException() {
        super("用户名已经存在");
    }
}
