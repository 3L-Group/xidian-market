package com.saturn.product.controller;

import com.saturn.common.entity.Product;
import com.saturn.common.utils.ResponseResult;
import com.saturn.product.service.ProductService;
import com.saturn.product.vo.MiniVO;
import com.saturn.product.vo.ProductVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/4/1 20:29
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 添加商品
     * @param product
     * @param pictureList
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addProduct(Product product, List<MultipartFile> pictureList) {
        return productService.addProduct(product, pictureList);
    }

    /**
     * 首页展示商品（目前固定展示 50 条）
     * 首先通过 Redis 中的浏览量来展示
     * 如果 Redis 中数据不够 50 条，则用数据库来凑（数据库根据时间戳来排序，商品越新的越先展示）
     * @return
     */
    @GetMapping("/all")
    public ResponseResult<List<MiniVO>> getProductList() {
        return null;
    }

    /**
     * 通过商品分类查询商品（展示规则同上）
     * @param categoryId
     * @return
     */
    @GetMapping("/category/add")
    public ResponseResult<List<MiniVO>> getProductListByCategory(Integer categoryId) {
        return null;
    }

    /**
     * 展示某个商品详情
     * @param productId
     * @return
     */
    @GetMapping("/details")
    public ResponseResult<ProductVO> getProductDetails(Integer productId) {
        return null;
    }

    /**
     * 更新商品信息
     * @param sellerId
     * @param productId
     * @return
     */
    @PostMapping("/update")
    public ResponseResult<Void> updateProduct(Integer sellerId, Integer productId) {
        return null;
    }
}
