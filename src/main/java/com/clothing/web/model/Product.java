package com.clothing.web.model;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private String type;

    private Integer area;

    private Integer sort;

    private String brand;

    private String measureUnit;

    private Integer status;

    private String img;

    private String des;

    private String storeWay;

    private Integer totalSellNum;

    private Integer weekSellNum;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getStoreWay() {
        return storeWay;
    }

    public void setStoreWay(String storeWay) {
        this.storeWay = storeWay == null ? null : storeWay.trim();
    }

    public Integer getTotalSellNum() {
        return totalSellNum;
    }

    public void setTotalSellNum(Integer totalSellNum) {
        this.totalSellNum = totalSellNum;
    }

    public Integer getWeekSellNum() {
        return weekSellNum;
    }

    public void setWeekSellNum(Integer weekSellNum) {
        this.weekSellNum = weekSellNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}