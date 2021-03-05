package com.cn.allen.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 * 不扫描有@Controller注解的类
 * 因为controller是属于Mvc（即DispatcherServlet容器）的，不归spring容器管
 */
@ComponentScan(value = "com.cn.allen",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, RestController.class})})
public class SpringContainer {
}
