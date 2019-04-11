package com.finance.qiongcang.entity;

import java.util.Set;

public class Company {
    private String cId;

    private String cName;

    private String cAddress;

    private String cPhone;

    private String cCharterz;

    private String cCharterf;

    private Integer cScale;

    private String cuId;

    private String cCountmoney;

    private String cCreatetime;

    private String cUpdatetime;

    private String cExpiretime;

    private Customer customer;

    private Set<Bill> billSet;

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcCharterz() {
        return cCharterz;
    }

    public void setcCharterz(String cCharterz) {
        this.cCharterz = cCharterz == null ? null : cCharterz.trim();
    }

    public String getcCharterf() {
        return cCharterf;
    }

    public void setcCharterf(String cCharterf) {
        this.cCharterf = cCharterf == null ? null : cCharterf.trim();
    }

    public Integer getcScale() {
        return cScale;
    }

    public void setcScale(Integer cScale) {
        this.cScale = cScale;
    }

    public String getCuId() {
        return cuId;
    }

    public void setCuId(String cuId) {
        this.cuId = cuId == null ? null : cuId.trim();
    }

    public String getcCountmoney() {
        return cCountmoney;
    }

    public void setcCountmoney(String cCountmoney) {
        this.cCountmoney = cCountmoney == null ? null : cCountmoney.trim();
    }

    public String getcCreatetime() {
        return cCreatetime;
    }

    public void setcCreatetime(String cCreatetime) {
        this.cCreatetime = cCreatetime == null ? null : cCreatetime.trim();
    }

    public String getcUpdatetime() {
        return cUpdatetime;
    }

    public void setcUpdatetime(String cUpdatetime) {
        this.cUpdatetime = cUpdatetime == null ? null : cUpdatetime.trim();
    }

    public String getcExpiretime() {
        return cExpiretime;
    }

    public void setcExpiretime(String cExpiretime) {
        this.cExpiretime = cExpiretime == null ? null : cExpiretime.trim();
    }
}