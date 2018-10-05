package com.clothing.web.enums;

/**
 * @Author: Partner
 * @Date: 2018/10/5 20:43
 * @Description
 */
public enum EnumDelete {
    NOT_DELETE(0, "未删除"),
    IS_DELETE(1, "删除"),
    ;
    private Integer statusCode;
    private String statusStr;

    EnumDelete(Integer statusCode, String statusStr) {
        this.statusCode = statusCode;
        this.statusStr = statusStr;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusStr() {
        return statusStr;
    }
}
