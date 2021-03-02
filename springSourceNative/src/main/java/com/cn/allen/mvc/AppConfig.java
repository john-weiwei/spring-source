package com.cn.allen.mvc;

import com.cn.allen.interceptor.UserInterceptor;
import com.cn.allen.interceptor.UserInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/22
 * @Description:
 */
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截器
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new UserInterceptor1()).addPathPatterns("/user/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.jsp("/jsp/",".jsp");
    }
}
