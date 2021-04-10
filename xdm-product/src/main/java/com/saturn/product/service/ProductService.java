package com.saturn.product.service;

import com.saturn.common.entity.Product;
import com.saturn.common.utils.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/4/10 21:03
 */
public interface ProductService {

    /**
     * 添加商品
     * @param product
     * @param pictureList
     * @return
     */
    ResponseResult<Void> addProduct(Product product, List<MultipartFile> pictureList);
}
