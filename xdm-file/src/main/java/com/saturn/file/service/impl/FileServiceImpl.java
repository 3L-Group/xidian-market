package com.saturn.file.service.impl;

import com.aliyun.oss.OSS;
import com.saturn.file.config.AliyunConfig;
import com.saturn.file.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Author: qyl
 * @Date: 2021/4/1 16:02
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private OSS oss;

    @Resource
    private AliyunConfig aliyunConfig;

    /**
     * 图片扩展名
     */
    private static final String IMG_EXT_NAME = "png";

    private static final String AVATAR_PREFIX = "xidian_market/avatar/";

    private static final String PRODUCT_PICTURE_PREFIX = "xidian_market/product_picture/";

    @Override
    public String uploadAvatar(String userId, MultipartFile file) {
        String filename = "user-" + userId + "." + IMG_EXT_NAME;
        String filePath = AVATAR_PREFIX + filename;

        String url = null;
        try {
            // 存储到oss
            oss.putObject(aliyunConfig.getBucketName(), filePath, new ByteArrayInputStream(file.getBytes()));
            url = aliyunConfig.getAvatarUrlPrefix() + filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回url
        return url;
    }

    @Override
    public String uploadProductPicture(String prefix, MultipartFile file) {
        String filename = prefix + "." + IMG_EXT_NAME;
        String filePath = PRODUCT_PICTURE_PREFIX + filename;

        String url = null;
        try {
            // 存储到oss
            oss.putObject(aliyunConfig.getBucketName(), filePath, new ByteArrayInputStream(file.getBytes()));
            url = aliyunConfig.getProductPictureUrlPrefix() + filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回url
        return url;
    }
}
