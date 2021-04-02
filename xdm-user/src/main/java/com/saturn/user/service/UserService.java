package com.saturn.user.service;

import com.saturn.common.entity.User;
import com.saturn.common.utils.ResponseResult;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:17
 */
public interface UserService {

    ResponseResult<Void> register(User user, String verifyCode);
}
