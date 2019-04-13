package com.finance.qiongcang.controller;

import com.finance.qiongcang.entity.Bill;
import com.finance.qiongcang.entity.Company;
import com.finance.qiongcang.service.IBillService;
import com.finance.qiongcang.service.ICompanyService;
import com.finance.qiongcang.util.DateUtil;
import com.finance.qiongcang.util.Tools;
import com.finance.qiongcang.util.UuidUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.awt.image.DataBufferUShort;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            //########添加账单##########
            bill.setbId(UuidUtil.get19Date());
            billService.save(bill);

            //###########修改企业的到期时间###############

            //1.查看当前修改 的企业
            Company dtoCompany = companyService.findDataById(bill.getcId());

            //2.获取当前账单递交的money
            Double billMoney = bill.getbMoney();

            //3.获取当前企业的代理费
            Double companyMoney = Double.valueOf(dtoCompany.getcCountmoney());

            //4.计算出增加的月份
            int month = (int) (billMoney / companyMoney);

            //5.计算最终的时间
            String date = DateUtil.addMonth(dtoCompany.getcExpiretime(), Tools.EX_DATE_TYPE, month);
            LOG.info("[companyName:" + dtoCompany.getcName() + ",month:" + month + ",endTime:" + date + ",updateTime:"+DateUtil.getTime()+"]");

            dtoCompany.setcExpiretime(date);
            companyService.update(dtoCompany);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
