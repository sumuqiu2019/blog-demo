package com.rainbow.blog.service;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import com.rainbow.blog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分类 服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
public interface CategoryService extends IService<Category> {

    PageVo queryPage(QueryCondition params);

}
