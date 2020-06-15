package com.rainbow.blog.commons.exception;

public class MailExistException extends RuntimeException {

    public MailExistException() {
        super("邮箱已经存在");
    }
}
