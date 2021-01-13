package com.cn.allen.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/7
 * @Description:
 */
@Component
//单例，无论取多少次都是同一个对象（即是同一个内存地址）
//ConfigurableBeanFactory.SCOPE_SINGLETON
//非单例，也就是每次都是一个新的对象；天生具有懒加载的特性，所有在启动的时候还没有创建实例
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(value = "allenScope")
public class PrototypeBean {

}
