package com.saturn.common.exception;

import com.saturn.common.utils.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: qyl
 * @Date: 2021/3/23 22:27
 * @Description:
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 处理响应异常
     * @param re
     * @return
     */
    @ExceptionHandler(ResponseException.class)
    public ResponseResult<Void> responseExceptionHandler(ResponseException re) {
        return ResponseResult.fail(re.getCode(), re.getMsg());
    }
}
