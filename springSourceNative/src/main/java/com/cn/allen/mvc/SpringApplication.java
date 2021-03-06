package com.cn.allen.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 */
public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class,args);
    }

    public static void run(Object object,String... args) {
        try {
            //创建容器
            Tomcat tomcatServer = new Tomcat();
            //设置端口号
            tomcatServer.setPort(9090);
            //读取项目路径，加载静态资源
            String basePath = System.getProperty("user.dir") + File.separator;
            tomcatServer.getHost().setAppBase(basePath);
            //改变文件读取路径，从resources目录下读取文件
            StandardContext scx = (StandardContext) tomcatServer.addWebapp("/" , basePath +"src"+File.separator+"main"+File.separator+"resources");
            //禁止重新载入
            scx.setReloadable(false);
            //Class文件读取地址
            File additionWebInfoClasses = new File("springSourceNative/target/classes");
            //创建WebRoot
            WebResourceRoot resource = new StandardRoot(scx);
            //tomcat内部读取Classes文件
            resource.addPreResources(new DirResourceSet(resource,"/springSourceNative/WEB-INF/classes",additionWebInfoClasses.getAbsolutePath(),"/"));
            tomcatServer.start();
            //异步等待请求执行
            tomcatServer.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
