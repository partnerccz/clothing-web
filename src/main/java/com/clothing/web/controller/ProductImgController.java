package com.clothing.web.controller;

import com.clothing.web.service.ProductImgService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品详细图片接口
 *
 * @author partner
 * @create 2018-10-01 4:19
 */
@Slf4j
@RestController
@RequestMapping("/productImg")
public class ProductImgController {

    @Autowired
    private ProductImgService productImgService;
    @GetMapping("/getProductPage")
    public ResponseEntity getProductPage(Integer productId) {
        try {
            log.info("【商品详细图片】 参数productId={}", productId);
            List<Map> list = productImgService.selectProductImgByProductId(productId);
            log.info("【商品详细图片】 返回接口list={}", list);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("【商品详细图片】 获取商品详细图片信息异常={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
