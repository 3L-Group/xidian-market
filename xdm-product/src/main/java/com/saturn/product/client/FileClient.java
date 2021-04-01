package com.saturn.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: qyl
 * @Date: 2021/4/1 21:17
 */
@FeignClient("xdm-file")
public interface FileClient {

    /**
     * 商品图片上传
     * @param prefix 商品图片名称（要保证唯一）
     * @param file
     * @return
     */
    @PostMapping(value = "/file/upload/productPicture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadProductPicture(@RequestParam("prefix") String prefix, @RequestPart("file") MultipartFile file);
}
