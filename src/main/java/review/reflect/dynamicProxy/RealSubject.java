package review.reflect.dynamicProxy;

import org.apache.poi.util.SystemOutLogger;

/**
 * 真实的主题实现了subject接口，代表被代理类
 * @author:ls
 * @date: 2020/9/17 11:47
 **/
public class RealSubject implements Subject {


    @Override
    public void sayHello() {
        System.out.println("hello");

    }

    @Override
    public void sayGoodbye() {
        System.out.println("goodbye");
    }
}
