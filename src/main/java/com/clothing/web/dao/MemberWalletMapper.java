package com.clothing.web.dao;

import com.clothing.web.model.MemberWallet;

public interface MemberWalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberWallet record);

    int insertSelective(MemberWallet record);

    MemberWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberWallet record);

    int updateByPrimaryKey(MemberWallet record);
}