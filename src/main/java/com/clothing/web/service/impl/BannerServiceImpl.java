package com.clothing.web.service.impl;

import com.clothing.web.dao.BannerMapper;
import com.clothing.web.model.Banner;
import com.clothing.web.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 标题
 *
 * @author partner
 * @create 2018-10-01 0:58
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> selectBannerByGroupKey(String groupKey) {
        return bannerMapper.selectBannerByGroupKey(groupKey);
    }
}
