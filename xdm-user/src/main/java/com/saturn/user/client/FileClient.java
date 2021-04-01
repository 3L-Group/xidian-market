package com.saturn.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: qyl
 * @Date: 2021/4/1 16:22
 */
@FeignClient("xdm-file")
public interface FileClient {

    /**
     * 头像上传（微服务间的通信）
     * 注意：使用 openfeign 传递参数含有文件类型时必须指定 consumes = MediaType.MULTIPART_FORM_DATA_VALUE
     * @param userId
     * @param file
     * @return
     */
    @PostMapping(value = "/file/upload/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadAvatar(@RequestParam("userId") String userId, @RequestPart("file") MultipartFile file);
}
