package com.finance.qiongcang.entity;

import java.util.Set;

public class Customer {
    private String cuId;

    private String cuUsername;

    private String cuOpenid;

    private String cuImg;

    private String cuAddress;

    private String cuPhone;

    private String cuIdentitynum;

    private String cuIdentityimg;

    private String cuWxname;

    private String cuWximg;

    private String createtime;

    private String updatetime;

    private Set<Company> companies;

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public String getCuId() {
        return cuId;
    }

    public void setCuId(String cuId) {
        this.cuId = cuId;
    }

    public String getCuUsername() {
        return cuUsername;
    }

    public void setCuUsername(String cuUsername) {
        this.cuUsername = cuUsername == null ? null : cuUsername.trim();
    }

    public String getCuOpenid() {
        return cuOpenid;
    }

    public void setCuOpenid(String cuOpenid) {
        this.cuOpenid = cuOpenid == null ? null : cuOpenid.trim();
    }

    public String getCuImg() {
        return cuImg;
    }

    public void setCuImg(String cuImg) {
        this.cuImg = cuImg == null ? null : cuImg.trim();
    }

    public String getCuAddress() {
        return cuAddress;
    }

    public void setCuAddress(String cuAddress) {
        this.cuAddress = cuAddress == null ? null : cuAddress.trim();
    }

    public String getCuPhone() {
        return cuPhone;
    }

    public void setCuPhone(String cuPhone) {
        this.cuPhone = cuPhone == null ? null : cuPhone.trim();
    }

    public String getCuIdentitynum() {
        return cuIdentitynum;
    }

    public void setCuIdentitynum(String cuIdentitynum) {
        this.cuIdentitynum = cuIdentitynum == null ? null : cuIdentitynum.trim();
    }

    public String getCuIdentityimg() {
        return cuIdentityimg;
    }

    public void setCuIdentityimg(String cuIdentityimg) {
        this.cuIdentityimg = cuIdentityimg == null ? null : cuIdentityimg.trim();
    }

    public String getCuWxname() {
        return cuWxname;
    }

    public void setCuWxname(String cuWxname) {
        this.cuWxname = cuWxname == null ? null : cuWxname.trim();
    }

    public String getCuWximg() {
        return cuWximg;
    }

    public void setCuWximg(String cuWximg) {
        this.cuWximg = cuWximg == null ? null : cuWximg.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}