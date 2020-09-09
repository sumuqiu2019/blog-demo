package com.rainbow.blog.aop.exception;

import lombok.ToString;

/**
 * 自定义异常
 *
 * @author 邢晨旭
 * @date 2020/08/27
 */
@ToString
public class MyException extends RuntimeException {

    private Integer code = 500;
    private String msg;
    private String url;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg, String url) {
        super(msg);
        this.msg = msg;
        this.url = url;
    }

    public MyException(String msg, Throwable e, String url) {
        super(msg, e);
        this.msg = msg;
        this.url = url;
    }

    public MyException(String msg, int code, String url) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.url = url;
    }

    public MyException(String msg, int code, Throwable e, String url) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
