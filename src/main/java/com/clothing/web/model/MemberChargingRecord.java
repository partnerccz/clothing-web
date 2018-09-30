package com.clothing.web.model;

import java.util.Date;

public class MemberChargingRecord {
    private Integer id;

    private Integer mid;

    private String numbers;

    private Double accrual;

    private String oddNumbers;

    private Integer tradingType;

    private Date tradingTime;

    private Integer tallyType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers == null ? null : numbers.trim();
    }

    public Double getAccrual() {
        return accrual;
    }

    public void setAccrual(Double accrual) {
        this.accrual = accrual;
    }

    public String getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(String oddNumbers) {
        this.oddNumbers = oddNumbers == null ? null : oddNumbers.trim();
    }

    public Integer getTradingType() {
        return tradingType;
    }

    public void setTradingType(Integer tradingType) {
        this.tradingType = tradingType;
    }

    public Date getTradingTime() {
        return tradingTime;
    }

    public void setTradingTime(Date tradingTime) {
        this.tradingTime = tradingTime;
    }

    public Integer getTallyType() {
        return tallyType;
    }

    public void setTallyType(Integer tallyType) {
        this.tallyType = tallyType;
    }
}