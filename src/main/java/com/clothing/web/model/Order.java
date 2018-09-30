package com.clothing.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String code;

    private Integer uId;

    private Byte orderStatus;

    private Byte payStatus;

    private BigDecimal payNeedMoney;

    private BigDecimal payTotalMoney;

    private String payCallback;

    private Integer paySuccess;

    private Integer buyUid;

    private Integer deliveryId;

    private Date payTime;

    private Integer refundStatus;

    private Date deliveryTime;

    private Date refundTime;

    private Date createTime;

    private Date updateTime;

    private Date cancelTime;

    private String cancelReason;

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

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public BigDecimal getPayNeedMoney() {
        return payNeedMoney;
    }

    public void setPayNeedMoney(BigDecimal payNeedMoney) {
        this.payNeedMoney = payNeedMoney;
    }

    public BigDecimal getPayTotalMoney() {
        return payTotalMoney;
    }

    public void setPayTotalMoney(BigDecimal payTotalMoney) {
        this.payTotalMoney = payTotalMoney;
    }

    public String getPayCallback() {
        return payCallback;
    }

    public void setPayCallback(String payCallback) {
        this.payCallback = payCallback == null ? null : payCallback.trim();
    }

    public Integer getPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(Integer paySuccess) {
        this.paySuccess = paySuccess;
    }

    public Integer getBuyUid() {
        return buyUid;
    }

    public void setBuyUid(Integer buyUid) {
        this.buyUid = buyUid;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
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

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }
}