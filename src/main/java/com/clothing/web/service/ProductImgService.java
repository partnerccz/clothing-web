package com.clothing.web.service;

import com.clothing.web.dao.ProductImgMapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品图片接口
 *
 * @author partner
 * @create 2018-10-01 4:17
 */
public interface ProductImgService {

    /**
     * 根据商品ID查询商品详细轮播图的图片
     *
     * @param productId
     * @return
     */
    List<Map> selectProductImgByProductId(Integer productId);
}
