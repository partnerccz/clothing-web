package com.clothing.web.dao;

import com.clothing.web.model.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    /**
     * 根据分组键获取banner数据
     *
     * @param groupKey
     * @return
     */
    List<Banner> selectBannerByGroupKey(String groupKey);
}