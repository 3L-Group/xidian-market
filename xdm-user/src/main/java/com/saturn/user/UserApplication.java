package com.saturn.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

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
