package com.cn.allen.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化servlet");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====doFilter===");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("执行销毁方法");
    }
}
