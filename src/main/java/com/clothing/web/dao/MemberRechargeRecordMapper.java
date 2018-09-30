package com.clothing.web.dao;

import com.clothing.web.model.MemberRechargeRecord;

public interface MemberRechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberRechargeRecord record);

    int insertSelective(MemberRechargeRecord record);

    MemberRechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberRechargeRecord record);

    int updateByPrimaryKey(MemberRechargeRecord record);
}