package com.saturn.common.entity;

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
@Table(name = "category")
public class Category {
    /**
     * 分类 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
}
