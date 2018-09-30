package com.clothing.web.service;

import com.clothing.web.model.Product;
import com.github.pagehelper.Page;

import java.util.Map;

/**
 * 描述:
 * 商品接口
 *
 * @author partner
 * @create 2018-10-01 2:51
 */
public interface ProductService {
    /**
     * 获取商品分页数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Map> selectProductPage(Integer pageSize, Integer pageNum);
}
