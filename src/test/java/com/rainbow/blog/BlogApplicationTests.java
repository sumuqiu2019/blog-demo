package com.rainbow.blog;

import com.rainbow.blog.utils.OssUploadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class BlogApplicationTests {


    @Test
    void contextLoads() {



    }

    /**
     * md文档内容读取测试
     */
    @Test
    void MdReadTest(){

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
