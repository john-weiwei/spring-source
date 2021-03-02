package com.cn.allen.tomcat;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 * 容器启动时，会加载扫描所有实现了javax.servlet.ServletContainerInitializer接口的类
 * 并调用onStartup方法
 */
@HandlesTypes(LoadServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     *
     * @param set 收集被@HandlesTypes注解类，实现了注解里面接口的类，
     *            并且通过反射拿到对应的实例，存放到set集合中
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator var4;
        if (set != null) {
            var4 = set.iterator();
            while (var4.hasNext()) {
                Class<?> clazz = (Class<?>) var4.next();
                if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers()) && LoadServlet.class.isAssignableFrom(clazz)) {
                    try {
                        ((LoadServlet)clazz.newInstance()).loadOnStartUp(servletContext);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
