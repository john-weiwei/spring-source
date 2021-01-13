package com.cn.allen.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 */
@Service
public class FactoryBeanDemo implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new FactoryB();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryB.class;
    }
}
