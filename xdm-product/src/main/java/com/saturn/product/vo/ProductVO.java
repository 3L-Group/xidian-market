package com.saturn.product.vo;

import com.saturn.common.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * 商品详情 VO
 * @Author: qyl
 * @Date: 2021/4/1 20:20
 */
@Data
public class ProductVO extends Product {
    /**
     * 商品图片
     */
    private List<String> pictureList;
    /**
     * 商品浏览量
     */
    private Long views;
}
