package com.saturn.product.service.impl;

import com.saturn.common.entity.Product;
import com.saturn.common.entity.ProductPicture;
import com.saturn.common.utils.ResponseResult;
import com.saturn.product.client.FileClient;
import com.saturn.product.mapper.ProductMapper;
import com.saturn.product.mapper.ProductPictureMapper;
import com.saturn.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author: qyl
 * @Date: 2021/4/10 21:03
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private FileClient fileClient;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductPictureMapper productPictureMapper;

    @Override
    public ResponseResult<Void> addProduct(Product product, List<MultipartFile> pictureList) {
        product.setTimestamp(System.currentTimeMillis());
        // insert product
        productMapper.insertSelective(product);


        for (MultipartFile picture : pictureList) {
            String picturePrefix = UUID.randomUUID().toString();
            String pictureUrl = fileClient.uploadProductPicture(picturePrefix, picture);
            // insert product_picture
            ProductPicture productPicture = new ProductPicture();
            productPicture.setProductId(product.getProductId());
            productPicture.setPictureUrl(pictureUrl);
            productPictureMapper.insertSelective(productPicture);
        }
        return ResponseResult.ok();
    }
}
