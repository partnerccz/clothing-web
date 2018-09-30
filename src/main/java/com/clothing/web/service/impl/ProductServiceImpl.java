package com.clothing.web.service.impl;

import com.clothing.web.constant.PageConstant;
import com.clothing.web.dao.ProductMapper;
import com.clothing.web.model.Product;
import com.clothing.web.service.ProductService;
import com.clothing.web.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 描述:
 * 商品接口实现类
 *
 * @author partner
 * @create 2018-10-01 2:52
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<Map> selectProductPage(Integer pageSize, Integer pageNum) {
        if (VerifyData.intIsNotNullOrZero(pageNum)) {
            pageNum = PageConstant.PAGE_NUM;
        }
        if (VerifyData.intIsNotNullOrZero(pageSize)) {
            pageSize = PageConstant.PAGE_SIZE;
        }
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectProductPage();
    }
}
