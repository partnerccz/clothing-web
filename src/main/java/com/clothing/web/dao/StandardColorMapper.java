package com.clothing.web.dao;

import com.clothing.web.model.StandardColor;

public interface StandardColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardColor record);

    int insertSelective(StandardColor record);

    StandardColor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardColor record);

    int updateByPrimaryKey(StandardColor record);
}