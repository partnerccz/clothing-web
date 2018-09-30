package com.clothing.web.dao;

import com.clothing.web.model.MemberChargingRecord;

public interface MemberChargingRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberChargingRecord record);

    int insertSelective(MemberChargingRecord record);

    MemberChargingRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberChargingRecord record);

    int updateByPrimaryKey(MemberChargingRecord record);
}