package com.saturn.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:18
 */
@SpringBootApplication
@MapperScan("com.saturn.user.mapper")
@EnableFeignClients
@EnableDiscoveryClient  // 可以不加
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
