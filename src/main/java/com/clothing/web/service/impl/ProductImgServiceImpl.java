package com.clothing.web.service.impl;

import com.clothing.web.dao.ProductImgMapper;
import com.clothing.web.model.ProductImg;
import com.clothing.web.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 商品图片接口实现类
 *
 * @author partner
 * @create 2018-10-01 4:18
 */
@Service
public class ProductImgServiceImpl implements ProductImgService {

    @Autowired
    private ProductImgMapper productImgMapper;

    @Override
    public List<Map> selectProductImgByProductId(Integer productId) {
        return productImgMapper.selectProductImgByProductId(productId);
    }
}
