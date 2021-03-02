package com.cn.allen.tomcat;

import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 */
public class LoadServletImpl implements LoadServlet {
    @Override
    public void loadOnStartUp(ServletContext servletContext) {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", "com.cn.allen.servlet.InitServlet");
        initServlet.setLoadOnStartup(1);
        initServlet.addMapping("/init");
    }
}
