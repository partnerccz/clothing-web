package com.clothing.web.service;

import com.clothing.web.model.Banner;

import java.util.List;

/**
 * 描述:
 * 标题
 *
 * @author partner
 * @create 2018-10-01 0:58
 */
public interface BannerService {
    /**
     * 根据分组键获取banner数据
     *
     * @param groupKey
     * @return
     */
    List<Banner> selectBannerByGroupKey(String groupKey);
}
