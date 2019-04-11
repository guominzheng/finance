package com.finance.qiongcang.service.impl;

import com.finance.qiongcang.entity.Bill;
import com.finance.qiongcang.mapper.BillMapper;
import com.finance.qiongcang.service.IBillService;
import com.finance.qiongcang.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("billService")
public class BillServiceImpl implements IBillService {
    @Autowired
    private BillMapper billMapper;
    @Override
    public void save(Bill bill) {
        bill.setbCreatetime(DateUtil.getTime());
        bill.setbUpdatetime(DateUtil.getTime());
        billMapper.insert(bill);
    }

    @Override
    public PageInfo<Bill> findAllData(Bill bill, Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        } else if (pageNum <= 0) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,10);
        return new PageInfo<>(billMapper.findAllData(bill));
    }
}
