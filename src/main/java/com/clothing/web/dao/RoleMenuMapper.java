package com.clothing.web.dao;

import com.clothing.web.model.RoleMenuKey;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);
}