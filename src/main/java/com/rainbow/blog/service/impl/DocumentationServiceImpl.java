package com.rainbow.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbow.blog.config.redis.GetRedisKey;
import com.rainbow.blog.entity.Documentation;
import com.rainbow.blog.mapper.DocumentationMapper;
import com.rainbow.blog.service.DocumentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档表 服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Service
@Slf4j
public class DocumentationServiceImpl extends ServiceImpl<DocumentationMapper, Documentation> implements DocumentationService {

    @Autowired
    DocumentationMapper mapper;

    @Override
    public Documentation getDocumentation(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public IPage<Documentation> getDocPageList(int page, int size) {
        LambdaQueryWrapper<Documentation> wrapper = Wrappers.lambdaQuery();
        IPage<Documentation> iPage = new Page<>(page, size);
        return mapper.selectPage(iPage, null);
    }
}

