package com.saturn.file.controller;

import com.saturn.file.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件相关接口
 * @Author: qyl
 * @Date: 2021/4/1 16:01
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    /**
     * 上传头像
     * @param userId
     * @param file
     * @return
     */
    @PostMapping("/file/upload/avatar")
    public String uploadAvatar(String userId, MultipartFile file) {
        return fileService.uploadAvatar(userId, file);
    }
}
