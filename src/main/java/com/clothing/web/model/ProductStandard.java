package com.clothing.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductStandard {
    private Integer id;

    private Integer productId;

    private String name;

    private String subTitle;

    private BigDecimal originalPrice;

    private BigDecimal sellPrice;

    private BigDecimal costPrice;

    private BigDecimal shippingFee;

    private Double cartonWeight;

    private Integer purchaseQuantityMin;

    private Integer purchaseQuantityMax;

    private Date buyStartTime;

    private Date buyEndTime;

    private Integer sortPurchase;

    private Integer sortSoldOut;

    private Integer sortSplit;

    private Integer stock;

    private Integer status;

    private Byte isDefault;

    private Integer purchaserUid;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getCartonWeight() {
        return cartonWeight;
    }

    public void setCartonWeight(Double cartonWeight) {
        this.cartonWeight = cartonWeight;
    }

    public Integer getPurchaseQuantityMin() {
        return purchaseQuantityMin;
    }

    public void setPurchaseQuantityMin(Integer purchaseQuantityMin) {
        this.purchaseQuantityMin = purchaseQuantityMin;
    }

    public Integer getPurchaseQuantityMax() {
        return purchaseQuantityMax;
    }

    public void setPurchaseQuantityMax(Integer purchaseQuantityMax) {
        this.purchaseQuantityMax = purchaseQuantityMax;
    }

    public Date getBuyStartTime() {
        return buyStartTime;
    }

    public void setBuyStartTime(Date buyStartTime) {
        this.buyStartTime = buyStartTime;
    }

    public Date getBuyEndTime() {
        return buyEndTime;
    }

    public void setBuyEndTime(Date buyEndTime) {
        this.buyEndTime = buyEndTime;
    }

    public Integer getSortPurchase() {
        return sortPurchase;
    }

    public void setSortPurchase(Integer sortPurchase) {
        this.sortPurchase = sortPurchase;
    }

    public Integer getSortSoldOut() {
        return sortSoldOut;
    }

    public void setSortSoldOut(Integer sortSoldOut) {
        this.sortSoldOut = sortSoldOut;
    }

    public Integer getSortSplit() {
        return sortSplit;
    }

    public void setSortSplit(Integer sortSplit) {
        this.sortSplit = sortSplit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getPurchaserUid() {
        return purchaserUid;
    }

    public void setPurchaserUid(Integer purchaserUid) {
        this.purchaserUid = purchaserUid;
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