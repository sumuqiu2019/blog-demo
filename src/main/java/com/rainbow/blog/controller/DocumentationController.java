package com.rainbow.blog.controller;

import com.rainbow.blog.commons.Resp;
import com.rainbow.blog.service.DocumentationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/saveDoc")
//    public Resp saveDoc(@RequestBody Documentation documentation){
//        return Resp.res(documentationService.saveDocumentation(documentation));
//    }

    @GetMapping("/getDoc/{id}")
    public Resp getDoc(@PathVariable("id") long id) {
        return Resp.ok(documentationService.getDocumentation(id));
    }

    @GetMapping("/getDoc/{page}/{size}")
    public Resp getDocPageList(@PathVariable("page") int page, @PathVariable("size") int size) {
        return Resp.ok(documentationService.getDocPageList(page, size));
    }

}
