package com.finance.qiongcang.service;

import com.finance.qiongcang.entity.Bill;
import com.github.pagehelper.PageInfo;

public interface IBillService {

    void save(Bill bill);

    PageInfo<Bill> findAllData(Bill bill, Integer pageNum);
}
