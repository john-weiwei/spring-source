package com.cn.allen.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;


/*
*    @PropertySource类似于
* <bean id="propertyConfigurerForProject" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="order" value="1" />
        <property name="ignoreUnresolvablePlaceholders" value="true" />
        <property name="location">
            <value>classpath:config/core/core.properties</value>
        </property>
    </bean>
*
* */

/**
 * @Bean注解在@Configuration和@Component注解中使用的区别
 * @Configuration:在@Configuration注解的类是经过cglib增强的，类里面的@Bean都是通过经过增强的类的代理去
 * 拿到的，获取到的是同一个实例。
 * @Component：在@Bean的方法中调用@Bean注解的其他方法，每次都有都是不同的实例
 */

@Configuration
@Component
//@PropertySource("classpath:config/core/core.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.url:jdbc}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

//    @Resource
    Environment environment;

    @Bean
    public DataSource comboPooledDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
//            comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
//            comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
//            comboPooledDataSource.setUser(environment.getProperty("jdbc.username"));
//            comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));

            comboPooledDataSource.setDriverClass(driverClass);
            comboPooledDataSource.setJdbcUrl(jdbcUrl);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setMinPoolSize(10);
            comboPooledDataSource.setMaxPoolSize(100);
            comboPooledDataSource.setMaxIdleTime(1800);
            comboPooledDataSource.setAcquireIncrement(3);
            comboPooledDataSource.setMaxStatements(1000);
            comboPooledDataSource.setInitialPoolSize(10);
            comboPooledDataSource.setIdleConnectionTestPeriod(60);
            comboPooledDataSource.setAcquireRetryAttempts(30);
            comboPooledDataSource.setBreakAfterAcquireFailure(false);
            comboPooledDataSource.setTestConnectionOnCheckout(false);
            comboPooledDataSource.setAcquireRetryDelay(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return comboPooledDataSource;
    }

//    @Bean
    public DataSource dynamicDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driverClass);
            comboPooledDataSource.setJdbcUrl(jdbcUrl);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setMinPoolSize(10);
            comboPooledDataSource.setMaxPoolSize(100);
            comboPooledDataSource.setMaxIdleTime(1800);
            comboPooledDataSource.setAcquireIncrement(3);
            comboPooledDataSource.setMaxStatements(1000);
            comboPooledDataSource.setInitialPoolSize(10);
            comboPooledDataSource.setIdleConnectionTestPeriod(60);
            comboPooledDataSource.setAcquireRetryAttempts(30);
            comboPooledDataSource.setBreakAfterAcquireFailure(false);
            comboPooledDataSource.setTestConnectionOnCheckout(false);
            comboPooledDataSource.setAcquireRetryDelay(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("ds1",comboPooledDataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(comboPooledDataSource);
        return dynamicDataSource;
    }
}
