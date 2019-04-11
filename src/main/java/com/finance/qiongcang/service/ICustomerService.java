package com.finance.qiongcang.service;

import com.finance.qiongcang.entity.Customer;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICustomerService {

    PageInfo<Customer> findAllData(Customer customer,Integer pageNum);

    List<Customer> findAllDataList(Customer customer);

    void save(Customer customer);
}
