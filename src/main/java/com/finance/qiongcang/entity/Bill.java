package com.finance.qiongcang.entity;

public class Bill {
    private String bId;

    private String bInfo;

    private Double bMoney;

    private Integer bPaytype;

    private String bCreatetime;

    private String bUpdatetime;

    private String cId;

    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getbInfo() {
        return bInfo;
    }

    public void setbInfo(String bInfo) {
        this.bInfo = bInfo == null ? null : bInfo.trim();
    }

    public Double getbMoney() {
        return bMoney;
    }

    public void setbMoney(Double bMoney) {
        this.bMoney = bMoney;
    }

    public Integer getbPaytype() {
        return bPaytype;
    }

    public void setbPaytype(Integer bPaytype) {
        this.bPaytype = bPaytype;
    }

    public String getbCreatetime() {
        return bCreatetime;
    }

    public void setbCreatetime(String bCreatetime) {
        this.bCreatetime = bCreatetime == null ? null : bCreatetime.trim();
    }

    public String getbUpdatetime() {
        return bUpdatetime;
    }

    public void setbUpdatetime(String bUpdatetime) {
        this.bUpdatetime = bUpdatetime == null ? null : bUpdatetime.trim();
    }
}