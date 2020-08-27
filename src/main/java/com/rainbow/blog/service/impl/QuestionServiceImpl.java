package com.rainbow.blog.service.impl;

import com.rainbow.blog.entity.Question;
import com.rainbow.blog.mapper.QuestionMapper;
import com.rainbow.blog.service.QuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Question> page = this.page(
            new Query<Question>().getPage(params),
            new QueryWrapper<Question>());
            return new PageVo(page);
    }

}

