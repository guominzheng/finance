package com.finance.qiongcang.controller;

import com.finance.qiongcang.entity.Customer;
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

@Controller
@RequestMapping(value = "customer", produces = "text/html;charset=utf-8")
public class CustomerController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(Customer customer, ModelAndView mv) {
        LOG.info("*------------查看法人列表-----------*");
        try {
            PageInfo pageData = customerService.findAllData(customer, 1);
            mv.addObject("varList", pageData.getList());
            mv.addObject("pages", pageData.getPages());
            mv.setViewName("member-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("404");
            return mv;
        }
    }

    @RequestMapping(value = "applist", method = RequestMethod.GET)
    public @ResponseBody
    String applist(Customer customer, Integer pageNum) {
        LOG.info("*------------法人列表查询-----------*");
        try {
            if (pageNum == null) {
                pageNum = 1;
            } else if (pageNum <= 0) {
                pageNum = 1;
            }
            PageInfo pageData = customerService.findAllData(customer, pageNum);
            return successPageInfo(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    String save(Customer customer) {
        LOG.info("*------------添加法人-----------*");
        try {
           customerService.save(customer);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
