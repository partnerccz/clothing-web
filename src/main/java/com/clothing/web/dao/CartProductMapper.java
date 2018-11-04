package com.clothing.web.dao;

import com.clothing.web.model.CartProduct;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CartProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartProduct record);

    int insertSelective(CartProduct record);

    CartProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartProduct record);

    int updateByPrimaryKey(CartProduct record);

    /**
     * 根据用户ID查询购物车信息
     *
     * @param memberId
     * @return
     */
    Page<Map> selectCartProductByMid(Integer memberId);
}