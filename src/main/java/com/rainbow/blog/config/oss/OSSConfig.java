package com.rainbow.blog.config.oss;

import lombok.Data;

import java.io.IOException;

/**
 * @author 邢晨旭
 * @Package com.rainbow.blog.config
 * @date 2020/6/13 9:24
 */
@Data
public class OSSConfig {

    private String bucketUrl;        //原图片服务器地址
    private String baseUrl;        //自定义解析后的图片服务器地址
    private String endpoint;        //连接区域地址
    private String accessKeyId;    //连接keyId
    private String accessKeySecret;    //连接秘钥
    private String bucketName;    //需要存储的bucketName
    private String picLocation;    //图片保存路径

    public OSSConfig() {
        try {
            this.bucketUrl = SystemConfig.getConfigResource("bucketUrl");
//            this.baseUrl = SystemConfig.getConfigResource("baseUrl");
            this.endpoint = SystemConfig.getConfigResource("endpoint");
            this.bucketName = SystemConfig.getConfigResource("bucketName");
            this.picLocation = SystemConfig.getConfigResource("picLocation");
            this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
            this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}