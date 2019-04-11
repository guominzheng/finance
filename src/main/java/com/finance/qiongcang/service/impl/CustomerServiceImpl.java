package com.finance.qiongcang.service.impl;

import com.finance.qiongcang.entity.Customer;
import com.finance.qiongcang.mapper.CustomerMapper;
import com.finance.qiongcang.service.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageInfo<Customer> findAllData(Customer customer,Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        return new PageInfo<>(customerMapper.findAllData(customer));
    }

    @Override
    public List<Customer> findAllDataList(Customer customer) {
        return customerMapper.findAllData(customer);
    }

    @Override
    public void save(Customer customer) {
        customerMapper.insert(customer);
    }
}
