package com.finance.qiongcang.mapper;

import com.finance.qiongcang.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String cId);

    List<Company> findAllData(Company company);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}