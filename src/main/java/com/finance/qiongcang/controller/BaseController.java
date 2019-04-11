package com.finance.qiongcang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }


    public String getReturnStr(String info, Object object) {
        Map returnMap = new HashMap();
        try {
            returnMap.put("code", "1");
            returnMap.put("data", object);
        } catch (Exception e) {
            returnMap.put("code", "2");
            returnMap.put("message", "程序出错请联系管理员!");
        }
        return JSONArray.toJSONString(returnMap);
    }

    // 将jsonArray字符串转换成List集合
    public static List jsonToList(String json, Class beanClass) {
        //这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
        return JSONObject.parseArray(json, beanClass);
    }

    public Map resultStr(int code, String msg) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    public Map resultStr(int code, String msg, Object data) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("code", code);
        json.put("msg", msg);
        json.put("data", data);
        return json;
    }

    public String successPageInfo(PageInfo data) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", data.getList());
        resultMap.put("pages", data.getPages());
        resultMap.put("totlCount", data.getTotal());
        return wvas(resultStr(1, "操作成功！", resultMap));
    }

    public String error() {
        return JSONArray.toJSONString(resultStr(2, "操作失败，请联系管理员！"));
    }

    public String error(String msg) {
        return JSONArray.toJSONString(resultStr(2, msg));
    }

    public String error(String msg, Object obj) {
        return JSONArray.toJSONString(resultStr(2, msg, obj));
    }

    public String success(Object data) {
        return JSONArray.toJSONString(resultStr(1, "操作成功！", data));
    }

    public String success() {
        return JSONArray.toJSONString(resultStr(1, "操作成功！"));
    }

    public String successv(Object data) {
        return wvas(resultStr(1, "操作成功！", data));
    }

    public String wvas(Object pd) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
