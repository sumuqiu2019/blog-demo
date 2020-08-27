package com.rainbow.blog.controller;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.rainbow.blog.service.DocumentationService;
import com.rainbow.blog.entity.Documentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.rainbow.blog.commons.bean.Resp;

/**
 * <p>
 * 文档表 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Api(tags = {"文档表"})
@RestController
@RequestMapping("/documentation")
public class DocumentationController {


    @Autowired
    private DocumentationService documentationService;


    @ApiOperation(value = "新增文档表")
    @PostMapping("/saveDocumentation")
    public Resp<String> add(@RequestBody Documentation documentation){
        documentationService.save(documentation);
        return Resp.ok(null);
    }

    @ApiOperation(value = "删除文档表")
    @PostMapping("/deleteDocumentationById/{id}")
    public Resp<String> delete(@PathVariable("id") Long id){
        documentationService.removeById(id);
        return Resp.ok(null);
    }

    @ApiOperation(value = "更新文档表")
    @PostMapping("/update")
    public Resp<String> update(@RequestBody Documentation documentation){
        documentationService.updateById(documentation);
        return Resp.ok(null);
    }

    @ApiOperation(value = "查询文档表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @PostMapping("queryDocumentationList")
    public Resp<PageVo> List(QueryCondition queryCondition){
        PageVo page = documentationService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    @ApiOperation(value = "id查询文档表")
    @GetMapping("/queryDocumentationById/{id}")
    public Resp<Documentation> findById(@PathVariable Long id){
        return Resp.ok(documentationService.getById(id));
    }

}
