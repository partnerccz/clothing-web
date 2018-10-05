package com.clothing.web.service.impl;

import com.clothing.web.dao.ProductStandardMapper;
import com.clothing.web.service.ProductStandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Map;

/**
 * @Author: Partner
 * @Date: 2018/10/5 1:49
 * @Description
 */
@Service
public class ProductStandardServiceImpl implements ProductStandardService {

    @Autowired
    private ProductStandardMapper productStandardMapper;
    @Override
    public Map selectProductDetailById(Integer psId) {
        return productStandardMapper.selectProductDetailById(psId);
    }
}
