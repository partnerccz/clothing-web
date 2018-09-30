package com.clothing.web.dao;

import com.clothing.web.model.ProductKeyword;

public interface ProductKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductKeyword record);

    int insertSelective(ProductKeyword record);

    ProductKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductKeyword record);

    int updateByPrimaryKey(ProductKeyword record);
}