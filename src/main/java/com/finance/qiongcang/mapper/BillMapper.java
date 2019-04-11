package com.finance.qiongcang.mapper;

import com.finance.qiongcang.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BillMapper {
    int deleteByPrimaryKey(Long bId);

    List<Bill> findAllData(Bill bill);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long bId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}