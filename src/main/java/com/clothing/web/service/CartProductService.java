package com.clothing.web.service;

import com.clothing.web.model.CartProduct;
import com.github.pagehelper.Page;

import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 19:58
 * @Description
 */
public interface CartProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(CartProduct record);

    int insertSelective(CartProduct record);

    CartProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartProduct record);

    int updateByPrimaryKey(CartProduct record);

    /**
     * 根据用户Id查询购物车信息
     * @param memberId 用户ID
     * @return
     */
    Page<Map> selectCartProductByMid(Integer memberId,Integer pageNum,Integer pageSize);
}
