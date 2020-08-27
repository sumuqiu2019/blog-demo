package com.rainbow.blog.service.impl;

import com.rainbow.blog.entity.Category;
import com.rainbow.blog.mapper.CategoryMapper;
import com.rainbow.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.Query;
import com.rainbow.blog.commons.bean.QueryCondition;
/**
 * <p>
 * 分类 服务实现类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Category> page = this.page(
            new Query<Category>().getPage(params),
            new QueryWrapper<Category>());
            return new PageVo(page);
    }

}

