package com.rainbow.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbow.blog.entity.Documentation;

/**
 * <p>
 * 文档表 服务类
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
public interface DocumentationService extends IService<Documentation> {

    /**
     * 从redis获取文档信息
     * @param id
     * @return
     */
    Documentation getDocumentation(Long id);

    /**
     * 分页查询文档
     * @param page
     * @param size
     * @return
     */
    IPage<Documentation> getDocPageList(int page, int size);
}
