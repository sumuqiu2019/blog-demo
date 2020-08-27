package com.rainbow.blog.service.impl;

import com.rainbow.blog.entity.UserDocumentation;
import com.rainbow.blog.mapper.UserDocumentationMapper;
import com.rainbow.blog.service.UserDocumentationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.Query;
import com.rainbow.blog.commons.bean.QueryCondition;
/**
 * <p>
 * 用户——文档表 服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Service
public class UserDocumentationServiceImpl extends ServiceImpl<UserDocumentationMapper, UserDocumentation> implements UserDocumentationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<UserDocumentation> page = this.page(
            new Query<UserDocumentation>().getPage(params),
            new QueryWrapper<UserDocumentation>());
            return new PageVo(page);
    }

}

