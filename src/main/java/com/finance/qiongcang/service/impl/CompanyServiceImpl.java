package com.finance.qiongcang.service.impl;

import com.finance.qiongcang.entity.Company;
import com.finance.qiongcang.mapper.CompanyMapper;
import com.finance.qiongcang.service.ICompanyService;
import com.finance.qiongcang.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("compnayService")
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public PageInfo<Company> findAllData(Company company ,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return new PageInfo<>(companyMapper.findAllData(company));
    }

    @Override
    public Company findDataById(String cid) {
        return companyMapper.selectByPrimaryKey(cid);
    }

    @Override
    public void update(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public void save(Company company) {
        company.setcCharterf("");
        company.setcCharterz("");
        company.setcScale(1);
        company.setcPhone("");
        company.setcCreatetime(DateUtil.getTime());
        company.setcUpdatetime(DateUtil.getTime());
        companyMapper.insert(company);
    }
}
