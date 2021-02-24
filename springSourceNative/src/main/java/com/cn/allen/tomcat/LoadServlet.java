package com.cn.allen.tomcat;

import javax.servlet.ServletContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 */
public interface LoadServlet {

    void loadOnStartUp(ServletContext servletContext);
}
