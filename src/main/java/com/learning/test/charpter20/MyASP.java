package com.learning.test.charpter20;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyASP {

    @Before("execution(* com.learning.test.charpter20.MyPojoBean1.sayAge(..))")
    public void  doSomethingBefore(){
        System.out.println("进入前置切面方法");
    }

    @After("@annotation(com.learning.test.charpter20.SQLString)")
    public void doSomethingAfter(){
        System.out.println("进入后置切面方法");
    }

    //利用aop配置注解的handler介入时间，此处表示在使用了@Logger注解的地方
    //一旦该方法被调用，那么通过切面的环绕监听方法对注解handler的调用，
    @Around("@annotation(logger)")
    public void doSomethingAround(ProceedingJoinPoint joinPoint,Logger logger) throws Throwable {
        joinPoint.proceed();
        //此处通过代理对象获取被代理对象，可以以此来解析被代理对象上的注解，通过反射，class.getAnnotations(),method,field
        //又可以通过 Map<String,Object> beans = context.getBeansWithAnnotation(DBTable.class)来获取使用某注解的所有类的map，接下来进行反射处理
        MyPojoBean1 m1 = (MyPojoBean1) joinPoint.getTarget();
        m1.speakSomething();
        System.out.println("进入环绕切面方法");
    }
}
