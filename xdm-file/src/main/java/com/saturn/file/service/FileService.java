package com.saturn.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: qyl
 * @Date: 2021/4/1 16:01
 */
public interface FileService {

    /**
     * 上传头像
     * @param userId
     * @param file
     * @return
     */
    String uploadAvatar(String userId, MultipartFile file);

    /**
     * 上传商品图片
     * @param prefix
     * @param file
     * @return
     */
    String uploadProductPicture(String prefix, MultipartFile file);
}
