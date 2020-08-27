package com.rainbow.blog.service;

import com.rainbow.blog.commons.bean.PageVo;
import com.rainbow.blog.commons.bean.QueryCondition;
import com.rainbow.blog.entity.UserDocumentation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户——文档表 服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
public interface UserDocumentationService extends IService<UserDocumentation> {

    PageVo queryPage(QueryCondition params);

}
