package com.cn.allen.controllerAdvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/3/3
 * @Description:
 * 统一异常处理，监听控制器异常
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({NullPointerException.class})
    public String handlerNullException() {
        System.out.println("出现了空指针异常");
        return "NullException";
    }

    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public String arithmeticException() {
        System.out.println("出现了算术异常");
        return "ArithmeticException";
    }
}
