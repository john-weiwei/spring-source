package com.cn.allen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/3/2
 * @Description:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("queryUser")
    @ResponseBody
    public String queryUser(@RequestParam(required = false) String language, HttpSession session) {
        session.setAttribute("language",language);
        return "Allen";
    }
}
