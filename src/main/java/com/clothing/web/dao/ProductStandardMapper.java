package com.clothing.web.dao;

import com.clothing.web.model.ProductStandard;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductStandard record);

    int insertSelective(ProductStandard record);

    ProductStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductStandard record);

    int updateByPrimaryKey(ProductStandard record);

    /**
     * 根据ID查询商品详情
     *
     * @param psId
     * @return
     */
    Map selectProductDetailById(Integer psId);
}