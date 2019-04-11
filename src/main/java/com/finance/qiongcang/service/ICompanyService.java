package com.finance.qiongcang.service;

import com.finance.qiongcang.entity.Company;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;


public interface ICompanyService {

    PageInfo<Company> findAllData(Company company, Integer pageNum);

    Company findDataById(String cid);

    void update(Company company);

    void save(Company company);
}
