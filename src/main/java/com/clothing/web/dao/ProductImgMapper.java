package com.clothing.web.dao;

import com.clothing.web.model.ProductImg;

public interface ProductImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);
}