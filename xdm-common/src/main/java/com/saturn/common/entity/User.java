package com.saturn.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: qyl
 * @Date: 2021/3/26 9:16
 */
@Data
@Table(name = "user")
public class User {
    /**
     * 用户 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * QQ号
     */
    private String qqNumber;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 用户地址（丁香11号楼...）
     */
    private String address;
    /**
     * 用户信誉（默认为 3，最高为 5；当信誉为 0 时注销用户）
     */
    private Integer credit;
}
