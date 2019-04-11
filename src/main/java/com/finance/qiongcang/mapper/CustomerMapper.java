package com.finance.qiongcang.mapper;

import com.finance.qiongcang.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(String cuId);

    int insert(Customer record);

    List<Customer> findAllData(Customer customer);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String cuId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}