package com.clothing.web.dao;

import com.clothing.web.model.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);

    /**
     * 根据商品ID查询商品详细轮播图的图片
     * @param productId
     * @return
     */
    List<Map> selectProductImgByProductId(Integer productId);
}