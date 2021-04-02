package com.saturn.user.service.impl;

import com.saturn.common.entity.User;
import com.saturn.common.enums.ResponseEnum;
import com.saturn.common.utils.ResponseResult;
import com.saturn.user.mapper.UserMapper;
import com.saturn.user.service.UserService;
import com.saturn.user.utils.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:17
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String DEFAULT_AVATAR_URL = "https://qyl-bucket.oss-cn-hangzhou.aliyuncs.com/xidian_market/avatar/default_avatar.png";

    //用户注册
    @Override
    public ResponseResult<Void> register(User user, String verifyCode) {
        //根据phone查询的条件
        Example phoneExample = new Example(User.class);
        Example.Criteria criteriaPhone = phoneExample.createCriteria();
        criteriaPhone.andCondition("phone = ",user.getPhone());
        //根据username查询的条件
        Example usernameExample = new Example(User.class);
        Example.Criteria criteriaUsername = usernameExample.createCriteria();
        criteriaUsername.andCondition("username = ",user.getUsername());

        //判断手机号是否已被注册
        if (userMapper.selectOneByExample(phoneExample) != null){
            return ResponseResult.fail(ResponseEnum.PHONE_IS_REGISTERED.getCode(), ResponseEnum.PHONE_IS_REGISTERED.getMsg());
        }

        //判断验证码是否正确
        if (!verifyCode.equals(stringRedisTemplate.opsForValue().get("verifyCode"))){
            return ResponseResult.fail(ResponseEnum.CODE_IS_INCORRECT.getCode(), ResponseEnum.CODE_IS_INCORRECT.getMsg());
        }

        //判断用户名是否已存在
        if (userMapper.selectOneByExample(usernameExample) != null){
            return ResponseResult.fail(ResponseEnum.USERNAME_EXIST.getCode(), ResponseEnum.USERNAME_EXIST.getMsg());
        }

        user.setAvatar(DEFAULT_AVATAR_URL);
        user.setCredit(3);

        //MD5密码加密
        user.setPhone(user.getPhone());
        user.setPassword(EncryptUtil.encryptByMD5(user.getPassword()));

        //持久化到数据库
        userMapper.insert(user);

        stringRedisTemplate.delete(verifyCode);

        return ResponseResult.ok();
    }
}
