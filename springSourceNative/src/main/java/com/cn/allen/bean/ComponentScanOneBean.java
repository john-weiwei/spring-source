package com.cn.allen.bean;

import com.cn.allen.datasource.DataSourceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/29
 * @Description:
 */
//@Component
@ComponentScan(basePackageClasses = DataSourceConfiguration.class)
public class ComponentScanOneBean {
}
