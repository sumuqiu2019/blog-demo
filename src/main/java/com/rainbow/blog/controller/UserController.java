package com.rainbow.blog.controller;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.rainbow.blog.service.UserService;
import com.rainbow.blog.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.rainbow.blog.commons.bean.Resp;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Api(tags = {"用户表"})
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @ApiOperation(value = "新增用户表")
    @PostMapping("/saveUser")
    public Resp<String> add(@RequestBody User user){
        userService.save(user);
        return Resp.ok(null);
    }

    @ApiOperation(value = "删除用户表")
    @PostMapping("/deleteUserById/{id}")
    public Resp<String> delete(@PathVariable("id") Long id){
        userService.removeById(id);
        return Resp.ok(null);
    }

    @ApiOperation(value = "更新用户表")
    @PostMapping("/update")
    public Resp<String> update(@RequestBody User user){
        userService.updateById(user);
        return Resp.ok(null);
    }

    @ApiOperation(value = "查询用户表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @PostMapping("queryUserList")
    public Resp<PageVo> List(QueryCondition queryCondition){
        PageVo page = userService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    @ApiOperation(value = "id查询用户表")
    @GetMapping("/queryUserById/{id}")
    public Resp<User> findById(@PathVariable Long id){
        return Resp.ok(userService.getById(id));
    }

}
