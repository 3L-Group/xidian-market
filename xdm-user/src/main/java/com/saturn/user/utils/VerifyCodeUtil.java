package com.saturn.user.utils;

import java.util.Random;

/**
 * @Author: qyl
 * @Date: 2021/2/5 20:45
 * @Description: 生成验证码工具类
 */
public class VerifyCodeUtil {

    /**
     * 随机生成 n 位数验证码
     * @param n 验证码位数
     * @return
     */
    public static String generateCode(int n) {
        Random random = new Random();
        int bound = 9 * (int) Math.pow(10, n - 1);
        int code = random.nextInt(bound) + (int) Math.pow(10, n - 1);
        return String.valueOf(code);
    }
}
