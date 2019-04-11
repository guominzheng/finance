package com.finance.qiongcang.controller;

import com.finance.qiongcang.entity.Company;
import com.finance.qiongcang.entity.Customer;
import com.finance.qiongcang.service.ICompanyService;
import com.finance.qiongcang.service.ICustomerService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "company", produces = "text/html;charset=utf-8")
public class CompanyController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(Company company, ModelAndView mv, HttpServletRequest request) {
        LOG.info("*------------查询企业列表-----------*");
        try {
            PageInfo pageData = companyService.findAllData(company, 1);
            mv.addObject("varList", pageData.getList());
            mv.addObject("pages", pageData.getPages());
            mv.setViewName("company-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("404");
            return mv;
        }
    }

    @RequestMapping(value = "applist", method = RequestMethod.GET)
    public @ResponseBody
    String applist(Company company, Integer pageNum) {
        LOG.info("*------------查询企业列表-----------*");
        try {
            if (pageNum == null) {
                pageNum = 1;
            } else if (pageNum <= 0) {
                pageNum = 1;
            }
            PageInfo pageData = companyService.findAllData(company, pageNum);
            return successPageInfo(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    /**
     * @param cid
     * @return
     */
    @RequestMapping(value = "findDataById", method = RequestMethod.GET)
    public @ResponseBody
    String findDataById(String cid) {
        LOG.info("*------------查询企业-----------*");
        try {
            java.util.Map resualtMap = new HashMap<String, Object>();
            List<Customer> customerList =  customerService.findAllDataList(new Customer());
            resualtMap.put("company", companyService.findDataById(cid));
            resualtMap.put("customer",customerList);
            return successv(resualtMap);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    /**
     * @param company
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody
    String findDataById(Company company) {
        LOG.info("*------------修改企业信息-----------*");
        try {
            companyService.update(company);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    /**
     * 添加 企业信息
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    String save(Company company) {
        LOG.info("*------------添加企业-----------*");
        LOG.info("接收数据:-->data[cName:" + company.getcName() + ",cuId:" + company.getCuId() + "]");
        try {
            companyService.save(company);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
