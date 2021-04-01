package com.saturn.product.vo;

import lombok.Data;

/**
 * 首页展示 VO
 * @Author: qyl
 * @Date: 2021/4/1 20:23
 */
@Data
public class MiniVO {
    /**
     * 商品 ID
     */
    private Integer productId;
    /**
     * 商品图片列表中的第一张图片
     */
    private String picture;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品浏览量
     */
    private Long views;
}
