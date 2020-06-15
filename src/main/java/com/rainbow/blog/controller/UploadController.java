package com.rainbow.blog.controller;

import com.rainbow.blog.commons.bean.Resp;
import com.rainbow.blog.commons.utils.FileUtils;
import com.rainbow.blog.commons.utils.JwtUtils;
import com.rainbow.blog.commons.utils.OssUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 邢晨旭
 * @Package com.rainbow.blog.controller
 * @date 2020/6/12 18:35
 */
@Slf4j
@RequestMapping("/upload")
public class UploadController {


    @PostMapping("/avatar")
    public Resp<Map<String, String>> uploadArticleImg(@RequestParam(value = "avatar") MultipartFile file, @RequestHeader("Authorization")String token) throws IOException {
        if (file == null || file.isEmpty() || file.getSize() == 0) {
            return Resp.fail(null);
        }
        if (file.getSize() > 10 * 1024 * 1024) {
            return Resp.fail(null);
        }
        Map<String, String> map = new HashMap<>();
        String fileType = FileUtils.getFileType(file);
        //OSS单文件上传,返回上传成功后的oss存储服务器中的url
        String fileName = OssUploadUtil.uploadFile(FileUtils.multipartFileToFile(file), fileType);
        map.put(file.getName(), fileName);
        log.info("用户{}上传了头像-->{}", JwtUtils.getJwtBody(token).get("name"),fileName);
        return Resp.ok(map);
    }


}
