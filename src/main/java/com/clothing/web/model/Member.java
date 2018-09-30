package com.clothing.web.model;

import java.util.Date;

public class Member {
    private Integer id;

    private String openid;

    private String nickName;

    private String headImg;

    private Integer mType;

    private Integer mGroup;

    private Integer isreceive;

    private Integer iswithdraw;

    private Integer isblock;

    private Integer sex;

    private Date registtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public Integer getmGroup() {
        return mGroup;
    }

    public void setmGroup(Integer mGroup) {
        this.mGroup = mGroup;
    }

    public Integer getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
    }

    public Integer getIswithdraw() {
        return iswithdraw;
    }

    public void setIswithdraw(Integer iswithdraw) {
        this.iswithdraw = iswithdraw;
    }

    public Integer getIsblock() {
        return isblock;
    }

    public void setIsblock(Integer isblock) {
        this.isblock = isblock;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }
}