package com.clothing.web.controller;

import com.clothing.web.constant.ResponseResultConstant;
import com.clothing.web.model.ProductStandard;
import com.clothing.web.service.ProductStandardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 1:50
 * @Description
 */
@RestController
@RequestMapping("/productStandard")
public class ProductStandardController {
    private Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductStandardService productStandardService;

    /**
     *
     * @param psId
     * @return
     */
    @GetMapping("/getProductStandardById")
    public ResponseEntity getProductStandardById(Integer psId) {
        try {
            log.info("【获取商品规格】 参数psId={}", psId);
            Map map = productStandardService.selectProductDetailById(psId);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【获取商品规格】 异常信息={}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResultConstant.EXCEPTION);
        }
    }


}
