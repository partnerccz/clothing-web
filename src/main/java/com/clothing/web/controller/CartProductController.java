package com.clothing.web.controller;

import com.alibaba.fastjson.JSON;
import com.clothing.web.constant.ResponseResultConstant;
import com.clothing.web.enums.EnumDelete;
import com.clothing.web.model.CartProduct;
import com.clothing.web.service.CartProductService;
import com.clothing.web.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 20:22
 * @Description
 */
@RestController
@RequestMapping("/cartProduct")
public class CartProductController {
    private Logger log = LoggerFactory.getLogger(CartProductController.class);

    @Autowired
    private CartProductService cartProductService;

    /**
     * 根据用户ID查询购物车信息
     * @param memberId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getCartProductByMid")
    public ResponseEntity getCartProductByMid(Integer memberId,Integer pageNum,Integer pageSize) {
        try {
            log.info("【购物车】  参数memberId={},pageNum={},pageSize={}", memberId, pageNum, pageSize);
            Page<Map> maps = cartProductService.selectCartProductByMid(memberId, pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(maps);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【购物车】 获取购物车信息异常，用户ID={}，异常信息={}", memberId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResultConstant.EXCEPTION);
        }
    }

    /**
     * 添加购物车
     * @param cartProduct
     * @return
     */
    @PostMapping("/addCartProduct")
    public ResponseEntity addCartProduct(CartProduct cartProduct) {
        try {
            cartProduct.setCreateTime(new Date());
            cartProduct.setUpdateTime(new Date());
            cartProduct.setIsDelete(EnumDelete.NOT_DELETE.getStatusCode());
            log.info("【购物车】 添加购物车，参数cartProduct={}", JSON.toJSON(cartProduct));
            int insert = cartProductService.insert(cartProduct);
            if (insert > 0) {
                return ResponseEntity.ok(ResponseResultConstant.SUCCESS);
            }
            return ResponseEntity.ok(ResponseResultConstant.FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【购物车】 添加购物车，异常信息={}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResultConstant.EXCEPTION);
        }
    }

    /**
     * 根据购物车ID删除购物信息
     * @param cartProductId 购物车ID
     * @return
     */
    @PostMapping("/delCartProductById")
    public ResponseEntity delCartProductById(Integer cartProductId) {
        try {
            log.info("【购物车】 删除购物车，购物车ID={}", cartProductId);
            CartProduct cartProduct = cartProductService.selectByPrimaryKey(cartProductId);
            cartProduct.setIsDelete(EnumDelete.IS_DELETE.getStatusCode());
            cartProduct.setUpdateTime(new Date());
            int i = cartProductService.updateByPrimaryKey(cartProduct);
            if (i > 0) {
                return ResponseEntity.ok(ResponseResultConstant.SUCCESS);
            }
            return ResponseEntity.ok(ResponseResultConstant.FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【购物车】 删除购物车，购物车ID={},异常信息={}", cartProductId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResultConstant.EXCEPTION);
        }
    }

    /**
     * 根据购物车ID删除购物信息
     * @param cartProductId 购物车ID
     * @return
     */
    @PostMapping("/modifyCartProductById")
    public ResponseEntity modifyCartProductById(Integer cartProductId,Integer buyNum) {
        try {
            log.info("【购物车】 修改购物车，购物车buyNum={}", buyNum);
            CartProduct cartProduct = cartProductService.selectByPrimaryKey(cartProductId);
            if (VerifyData.intIsNotNullOrZero(buyNum)) {
                return ResponseEntity.ok(ResponseResultConstant.FAIL);
            }
            cartProduct.setBuyNum(buyNum);
            cartProduct.setUpdateTime(new Date());
            int i = cartProductService.updateByPrimaryKey(cartProduct);
            if (i > 0) {
                return ResponseEntity.ok(ResponseResultConstant.SUCCESS);
            }
            return ResponseEntity.ok(ResponseResultConstant.FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【购物车】 修改购物车，购物车ID={},异常信息={}", cartProductId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseResultConstant.EXCEPTION);
        }
    }
}
