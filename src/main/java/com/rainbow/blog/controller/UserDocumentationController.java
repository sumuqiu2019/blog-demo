package com.rainbow.blog.controller;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.rainbow.blog.service.UserDocumentationService;
import com.rainbow.blog.entity.UserDocumentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.rainbow.blog.commons.bean.Resp;

/**
 * <p>
 * 用户——文档表 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Api(tags = {"用户——文档表"})
@RestController
@RequestMapping("/userDocumentation")
public class UserDocumentationController {


    @Autowired
    private UserDocumentationService userDocumentationService;


    @ApiOperation(value = "新增用户——文档表")
    @PostMapping("/saveUserDocumentation")
    public Resp<String> add(@RequestBody UserDocumentation userDocumentation){
        userDocumentationService.save(userDocumentation);
        return Resp.ok(null);
    }

    @ApiOperation(value = "删除用户——文档表")
    @PostMapping("/deleteUserDocumentationById/{id}")
    public Resp<String> delete(@PathVariable("id") Long id){
        userDocumentationService.removeById(id);
        return Resp.ok(null);
    }

    @ApiOperation(value = "更新用户——文档表")
    @PostMapping("/update")
    public Resp<String> update(@RequestBody UserDocumentation userDocumentation){
        userDocumentationService.updateById(userDocumentation);
        return Resp.ok(null);
    }

    @ApiOperation(value = "查询用户——文档表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @PostMapping("queryUserDocumentationList")
    public Resp<PageVo> List(QueryCondition queryCondition){
        PageVo page = userDocumentationService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    @ApiOperation(value = "id查询用户——文档表")
    @GetMapping("/queryUserDocumentationById/{id}")
    public Resp<UserDocumentation> findById(@PathVariable Long id){
        return Resp.ok(userDocumentationService.getById(id));
    }

}
