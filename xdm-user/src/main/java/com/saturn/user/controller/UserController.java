package com.saturn.user.controller;

import com.saturn.common.entity.User;
import com.saturn.common.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("/send")
    public ResponseResult<String> sendVerifyCode(String phone) {
        return null;
    }

    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<Void> register(User user, String verifyCode) {
        return null;
    }

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseResult<User> login(String phone, String password) {
        return null;
    }

    /**
     * 修改头像
     * @param avatar
     * @return
     */
    @PostMapping("/update/avatar")
    public ResponseResult<Void> updateAvatar(MultipartFile avatar) {
        return null;
    }
}
