package com.clothing.web.service.impl;

import com.clothing.web.constant.PageConstant;
import com.clothing.web.dao.CartProductMapper;
import com.clothing.web.model.CartProduct;
import com.clothing.web.service.CartProductService;
import com.clothing.web.utils.VerifyData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 20:15
 * @Description
 */
@Service
public class CartProductServiceImpl implements CartProductService {

    @Autowired
    private CartProductMapper cartProductMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cartProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CartProduct record) {
        return cartProductMapper.insert(record);
    }

    @Override
    public int insertSelective(CartProduct record) {
        return 0;
    }

    @Override
    public CartProduct selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CartProduct record) {
        return cartProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CartProduct record) {
        return cartProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<Map> selectCartProductByMid(Integer memberId, Integer pageNum, Integer pageSize) {
        if (VerifyData.intIsNotNullOrZero(pageNum)) {
            pageNum = PageConstant.PAGE_NUM;
        }
        if (VerifyData.intIsNotNullOrZero(pageSize)) {
            pageSize = PageConstant.PAGE_SIZE;
        }
        PageHelper.startPage(pageNum, pageSize);
        return cartProductMapper.selectCartProductByMid(memberId);
    }
}
