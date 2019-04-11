package com.finance.qiongcang.controller;

import com.finance.qiongcang.entity.Bill;
import com.finance.qiongcang.entity.Company;
import com.finance.qiongcang.service.IBillService;
import com.finance.qiongcang.service.ICompanyService;
import com.finance.qiongcang.util.UuidUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bill/")
public class BillController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private IBillService billService;
    @Autowired
    private ICompanyService companyService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Bill bill, Integer pageNum) {
        LOG.info("*------------查询账单-----------*");
        try {
            PageInfo pageData = billService.findAllData(bill, pageNum);
            return successPageInfo(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Bill bill) {
        LOG.info("*------------添加账单-----------*");
        try {
            bill.setbId(UuidUtil.get19Date());
            Company dtoCompany = companyService.findDataById(bill.getcId());
            Double billMoney = bill.getbMoney();
            Double companyMoney  = Double.valueOf(dtoCompany.getcCountmoney());
            int a = (int)(billMoney/companyMoney);
            billService.save(bill);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
