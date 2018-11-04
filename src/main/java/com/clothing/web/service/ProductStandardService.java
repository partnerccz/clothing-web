package com.clothing.web.service;

import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 1:49
 * @Description
 */
public interface ProductStandardService {
    /**
     * 根据ID查询商品详情
     *
     * @param psId
     * @return
     */
    Map selectProductDetailById(Integer psId);
}
