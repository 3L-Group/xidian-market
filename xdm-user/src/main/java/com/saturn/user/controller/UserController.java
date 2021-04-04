package com.saturn.user.controller;

import com.saturn.common.entity.User;
import com.saturn.common.entity.po.TokenPO;
import com.saturn.common.utils.ResponseResult;
import com.saturn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("/send")
    public ResponseResult<String> sendVerifyCode(String phone) {
        return userService.sendVerifyCode(phone);
    }

    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<Void> register(User user, String verifyCode) {
        return userService.register(user,verifyCode);
    }

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseResult<TokenPO> login(String phone, String password) {
        return userService.login(phone,password);
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
