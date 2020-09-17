package review.reflect.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author:ls invocationHandler处理器
 * @date: 2020/9/17 11:49
 **/
public class MyInvocationHandler implements InvocationHandler {
    private Subject s;

    public MyInvocationHandler(Subject s) {
        this.s = s;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object o = method.invoke(s,args);
        System.out.println("after");
        return o;
    }
}
