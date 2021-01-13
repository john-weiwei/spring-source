package com.cn.allen.beanDefinition;

import java.lang.annotation.*;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/23
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyService {

    String value() default "";
}
