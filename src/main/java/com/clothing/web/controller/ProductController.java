package com.clothing.web.controller;

import com.clothing.web.model.Product;
import com.clothing.web.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 描述:
 * 商品实现接口
 *
 * @author partner
 * @create 2018-10-01 2:57
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/getProductPage")
    public ResponseEntity getProductPage(Integer pageSize, Integer pageNum) {
        try {
            log.info("【商品】 分页参数pageSize={},pageNum={}", pageSize, pageNum);
            Page<Map> products = productService.selectProductPage(pageSize, pageNum);
            PageInfo pageInfo = new PageInfo(products);
            log.info("【商品】 返回接口pageInfo={}", pageInfo);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("【商品】 获取商品分页信息异常={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
