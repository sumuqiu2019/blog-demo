package com.rainbow.blog.commons.exception;

public class InformationLossException extends RuntimeException {

    public InformationLossException() {
        super("信息缺失，请检查输入的信息");
    }
}
