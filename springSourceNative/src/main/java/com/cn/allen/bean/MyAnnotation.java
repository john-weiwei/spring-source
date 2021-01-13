package com.cn.allen.bean;

import com.cn.allen.beanDefinition.MyService;
import lombok.Data;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/23
 * @Description:
 */
@Data
@MyService
public class MyAnnotation {

    private String name = "allen";
}
