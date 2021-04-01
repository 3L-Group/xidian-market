package com.saturn.file.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qyl
 * @Date: 2021/2/21 13:12
 * @Description:
 */
@Configuration
@Data
public class AliyunConfig {

    // 地域节点
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.avatarUrlPrefix}")
    private String avatarUrlPrefix;

    @Bean
    public OSS oss() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
