package com.cn.allen.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/7
 * @Description:
 */
@Component
@Scope(value = RequestAttributes.REFERENCE_REQUEST)
public class RequestSessionBean {

}
