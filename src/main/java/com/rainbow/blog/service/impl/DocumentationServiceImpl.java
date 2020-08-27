package com.rainbow.blog.service.impl;

import com.rainbow.blog.entity.Documentation;
import com.rainbow.blog.mapper.DocumentationMapper;
import com.rainbow.blog.service.DocumentationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.Query;
import com.rainbow.blog.commons.bean.QueryCondition;
/**
 * <p>
 * 文档表 服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Service
public class DocumentationServiceImpl extends ServiceImpl<DocumentationMapper, Documentation> implements DocumentationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Documentation> page = this.page(
            new Query<Documentation>().getPage(params),
            new QueryWrapper<Documentation>());
            return new PageVo(page);
    }

}

