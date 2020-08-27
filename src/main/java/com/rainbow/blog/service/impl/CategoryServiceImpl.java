package com.rainbow.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbow.blog.entity.Category;
import com.rainbow.blog.mapper.CategoryMapper;
import com.rainbow.blog.service.CategoryService;
import org.springframework.stereotype.Service;
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


}

