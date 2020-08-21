package com.aop;

import com.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author:11411
 * @date: 2020/8/21 17:04
 * 自定义注解处理器
 **/
@Aspect
@Component
public class LogAspect {

    //定义切入点，此处为使用了log注解的
    @Pointcut("@annotation(com.annotation.Log)")
    public void doJoinPointCut(){

    }

    //在切入点之前进行处理，还有after，around等
    @Before("doJoinPointCut()")
    public void doBefore(JoinPoint joinPoint){
        //joinPoint中有很多被切入点本身信息，应该在执行handle方法后执行joinPoint本身的方法
        //并且需要注入joinPoint本身的方法返回值，如果需要joinpoint本身方法的返回值，那么
        //应该在切入点后返回joinPoint方法的返回值，且需要注意返回值类型
        handleLog(joinPoint);
    }

    //定义真正的处理逻辑，此处简单的打印
    public void handleLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Log log = method.getAnnotation(Log.class);
        if(log != null){
            System.out.println(log.value());
        }
    }
}
