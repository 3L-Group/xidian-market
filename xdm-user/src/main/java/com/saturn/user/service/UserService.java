package com.saturn.user.service;

import com.saturn.common.entity.User;
import com.saturn.common.entity.po.TokenPO;
import com.saturn.common.utils.ResponseResult;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:17
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    ResponseResult<Void> register(User user, String verifyCode);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    ResponseResult<String> sendVerifyCode(String phone);

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    ResponseResult<TokenPO> login(String phone, String password);
}
