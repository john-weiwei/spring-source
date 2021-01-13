package com.cn.allen.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/7
 * @Description:
 * 域：指的是不同bean的管理方式
 */
public class CustomScope implements Scope {

    ThreadLocal<Object> local = new ThreadLocal();

    /**
     * 自己管理bean
     * @param name
     * @param objectFactory
     * @return
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("=====CustomScope====");
        if (local.get() != null) {
            return local.get();
        } else {
            Object object = objectFactory.getObject();
            local.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
