package com.rainbow.blog.controller;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.rainbow.blog.service.CategoryService;
import com.rainbow.blog.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.rainbow.blog.commons.bean.Resp;

/**
 * <p>
 * 分类 前端控制器
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Api(tags = {"分类"})
@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @ApiOperation(value = "新增分类")
    @PostMapping("/saveCategory")
    public Resp<String> add(@RequestBody Category category){
        categoryService.save(category);
        return Resp.ok(null);
    }

    @ApiOperation(value = "删除分类")
    @PostMapping("/deleteCategoryById/{id}")
    public Resp<String> delete(@PathVariable("id") Long id){
        categoryService.removeById(id);
        return Resp.ok(null);
    }

    @ApiOperation(value = "更新分类")
    @PostMapping("/update")
    public Resp<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return Resp.ok(null);
    }

    @ApiOperation(value = "查询分类分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @PostMapping("queryCategoryList")
    public Resp<PageVo> List(QueryCondition queryCondition){
        PageVo page = categoryService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    @ApiOperation(value = "id查询分类")
    @GetMapping("/queryCategoryById/{id}")
    public Resp<Category> findById(@PathVariable Long id){
        return Resp.ok(categoryService.getById(id));
    }

}
