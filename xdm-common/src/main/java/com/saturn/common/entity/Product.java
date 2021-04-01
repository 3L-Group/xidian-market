package com.saturn.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: qyl
 * @Date: 2021/4/1 19:43
 */
@Data
@Table(name = "product")
public class Product {
    /**
     * 商品 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    /**
     * 卖家 ID
     */
    private Integer sellerId;
    /**
     * 分类 ID
     */
    private Integer categoryId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品简介
     */
    private String info;
    /**
     * 商品库存（库存为 0 自动下架）
     */
    private Integer stock;
    /**
     * 商品创建的时间戳（后面根据这个来展示，不需要展示）
     */
    @JsonIgnore
    private Long timestamp;
}
