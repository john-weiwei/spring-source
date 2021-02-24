package com.cn.allen.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/20
 * @Description:
 */
@ComponentScan(value = "com.cn.allen",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
public class MvcContainer {
}
