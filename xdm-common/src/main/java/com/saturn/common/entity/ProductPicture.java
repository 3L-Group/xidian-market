package com.saturn.common.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: qyl
 * @Date: 2021/4/1 20:05
 */
@Data
@Table(name = "product_picture")
public class ProductPicture {
    /**
     * 数据库 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ppid;
    /**
     * 商品 ID
     */
    private Integer productId;
    /**
     * 图片 URL
     */
    private String pictureUrl;
}
