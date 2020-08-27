package com.rainbow.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbow.blog.entity.Question;
import com.rainbow.blog.mapper.QuestionMapper;
import com.rainbow.blog.service.QuestionService;
import org.springframework.stereotype.Service;
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



}

