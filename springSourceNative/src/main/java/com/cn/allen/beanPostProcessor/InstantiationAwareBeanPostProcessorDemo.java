package com.cn.allen.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/30
 * @Description:
 */
//@Service
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName )throws BeansException {
        return false;
    }
}
