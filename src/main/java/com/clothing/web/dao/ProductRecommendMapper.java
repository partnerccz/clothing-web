package com.clothing.web.dao;

import com.clothing.web.model.ProductRecommend;

public interface ProductRecommendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}