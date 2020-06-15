package com.rainbow.blog;

import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.rainbow.blog.commons.utils.FileUtils;
import com.rainbow.blog.commons.utils.OssUploadUtil;
import com.rainbow.blog.entity.UserInfo;
import com.rainbow.blog.vo.LoginRespVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {



    }

    @Test
    void myTest(){

        File file = new File("C:\\Users\\XCX\\Desktop\\docs\\其他细节点.md");
        String fileType = "md";
        try {
            String canonicalPath = file.getCanonicalPath();
            System.err.println(canonicalPath);
        }catch (Exception e){

        }
        String fileName = OssUploadUtil.uploadFile(file, fileType);
        System.out.println(fileName);
    }

}
