package com.cn.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/7
 * @Description:
 */
@Controller
@RequestMapping("common")
public class CommonController {

    @Autowired
    private ApplicationContext applicationContext;

    @ResponseBody
    @RequestMapping("index")
    public String index() {
        System.out.println(applicationContext.getBean("requestSessionBean"));
        return "requestSessionBean";
    }

    /**
     * consumes：指定处理请求的提交内容类型（Content-Type），例如application/json,text/html;
     * produces：指定返回的内容类型，仅当request请求头中的（Accept）类型中包含该指定类型才返回；
     * params：指定request中必须包含某些参数值才让该方法处理
     * headers：指定request中必须包含某些指定的header值，才能让该方法处理请求
     * @return
     */
//    @RequestMapping(value = "getUser"
//            ,method = RequestMethod.GET
//            ,params = "username=allen"
//            ,consumes = "application/json"
//            ,produces = "application/json"
//            ,headers = "Referer=http://www.qq.com")
    @RequestMapping(value = "getUser")
    @ResponseBody
    public String getUserInfo() {
        return "xxx";
    }
}
