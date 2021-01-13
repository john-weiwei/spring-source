package com.cn.allen.beanDefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/22
 * @Description:
 */
@Component
public class BeanDefinitionTest implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(BeanClass.class);
        genericBeanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("username","allenZhang"));
        registry.registerBeanDefinition("beanClass",genericBeanDefinition);

        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new AnnotationTypeFilter(MyService.class));
        scanner.scan("com.cn.allen");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    /**
     * BeanDefinitionRegistryPostProcessor接口的多个不同实现，
     * 排序之后会按照这个数字去排序，
     * 数值越小，优先级就越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
