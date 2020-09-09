package com.rainbow.blog.commons;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回
 *
 * @author 邢晨旭
 * @date 2020/08/27
 */
@ApiModel("请求统一返回")
@Data
public class Resp<T> {

    /**
     * 请求成功判定
     */
    @ApiModelProperty("请求成功判定")
    private Boolean success = true;
    /**
     * 请求返回编码
     */
    @ApiModelProperty("请求返回编码")
    private Integer code;
    /**
     * 请求返回描述
     */
    @ApiModelProperty("请求返回描述")
    private String msg;
    /**
     * 请求返回参数
     */
    @ApiModelProperty("请求返回参数")
    private T data;

    public Resp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp() {
    }

    public Resp(T data) {
        this.data = data;
    }

    public static <T> Resp<T> ok(T data) {
        Resp<T> resp = new Resp<T>(data);
        resp.setCode(200);
        resp.setMsg("操作成功");
        return resp;
    }

    public static <T> Resp<T> res(boolean success) {
        Resp<T> resp = new Resp<T>();
        resp.setCode(200);
        resp.setMsg("操作成功");
        if (!success) {
            resp.setCode(400);
            resp.setSuccess(false);
            resp.setMsg("操作失败");
        }
        return resp;
    }

    public static <T> Resp<T> fail() {
        Resp<T> resp = new Resp<T>();
        resp.setCode(400);
        resp.setSuccess(false);
        resp.setMsg("操作失败");
        return resp;
    }

    public Resp<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Resp<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

}
