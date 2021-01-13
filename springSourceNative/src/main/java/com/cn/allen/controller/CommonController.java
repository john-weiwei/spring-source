package com.cn.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
