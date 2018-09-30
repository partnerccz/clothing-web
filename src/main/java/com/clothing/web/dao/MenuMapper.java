package com.clothing.web.dao;

import com.clothing.web.model.Menu;
import com.clothing.web.model.MenuKey;

public interface MenuMapper {
    int deleteByPrimaryKey(MenuKey key);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(MenuKey key);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}