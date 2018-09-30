package com.clothing.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private Integer id;

    private String code;

    private Integer productId;

    private Integer productStandardId;

    private String measureUnit;

    private Integer num;

    private Long originalPrice;

    private BigDecimal sellPrice;

    private BigDecimal sendGoodsPay;

    private BigDecimal totalPay;

    private String buyRemark;

    private Date sendGoodsTime;

    private Date takeGoodsTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductStandardId() {
        return productStandardId;
    }

    public void setProductStandardId(Integer productStandardId) {
        this.productStandardId = productStandardId;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getSendGoodsPay() {
        return sendGoodsPay;
    }

    public void setSendGoodsPay(BigDecimal sendGoodsPay) {
        this.sendGoodsPay = sendGoodsPay;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public String getBuyRemark() {
        return buyRemark;
    }

    public void setBuyRemark(String buyRemark) {
        this.buyRemark = buyRemark == null ? null : buyRemark.trim();
    }

    public Date getSendGoodsTime() {
        return sendGoodsTime;
    }

    public void setSendGoodsTime(Date sendGoodsTime) {
        this.sendGoodsTime = sendGoodsTime;
    }

    public Date getTakeGoodsTime() {
        return takeGoodsTime;
    }

    public void setTakeGoodsTime(Date takeGoodsTime) {
        this.takeGoodsTime = takeGoodsTime;
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