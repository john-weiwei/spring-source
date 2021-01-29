package com.cn.allen.transaction;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/29
 * @Description:
 * 配置事务管理器
 */
//@Enable...肯定有一个@Import标签
//@Component
@EnableTransactionManagement
@MapperScan(basePackages = "com.cn.allen.dao",annotationClass = Repository.class)
public class EnableTransactionManagementBean {

//    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    /**
     * 这样也是可以的
     * @param dataSource
     * @return
     */
//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager(DataSource dataSource) {
//        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
//        dtm.setDataSource(dataSource);
//        return dtm;
//    }

}
