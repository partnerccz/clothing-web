package com.clothing.web.dao;

import com.clothing.web.model.StandardSize;

public interface StandardSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardSize record);

    int insertSelective(StandardSize record);

    StandardSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardSize record);

    int updateByPrimaryKey(StandardSize record);
}