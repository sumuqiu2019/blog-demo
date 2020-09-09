package com.rainbow.blog.config.redis;

/**
 * @author 邢晨旭
 * @date 2020/09/08
 */
public class GetRedisKey {

    private static  final String REDIS_JOINER = "-";
    private static  final String REDIS_PREFIX = "blog-";

    public static String getDocumentationKey(Long id){
        return REDIS_PREFIX+"documentation"+REDIS_JOINER+id;
    }

}
