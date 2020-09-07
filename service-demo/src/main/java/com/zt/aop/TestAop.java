package com.zt.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/9/7 16:03
 */
@Aspect
@Component
public class TestAop {

    @Pointcut("execution(public * com.zt.aop..*.*(..))")
    public void webLog(){}
}
