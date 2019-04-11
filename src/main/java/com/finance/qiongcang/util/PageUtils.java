package com.finance.qiongcang.util;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {

    public static int[] getPageNum(HttpServletRequest request) {
        int pageNum = 1;
        int pageSize = 10;
        Object pageNumstr = request.getAttribute("pageNum");
        Object pageSizestr = request.getAttribute("pageSize");
        //判断pageNum是否为空
        if (null != pageNumstr && !"".equals(pageNumstr.toString())) {
            pageNum = Integer.parseInt(pageNumstr.toString());
        }
        //判断pageS是否为空
        if (null != pageSizestr && !"".equals(pageSizestr.toString())) {
            pageSize = Integer.parseInt(pageSizestr.toString());
        }
        int[] returnNum = {pageNum, pageSize};
        return returnNum;
    }
}
