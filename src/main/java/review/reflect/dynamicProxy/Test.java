package review.reflect.dynamicProxy;

import lombok.SneakyThrows;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author:ls
 * @date: 2020/9/17 11:53
 **/
public class Test {

    public static void main(String[] args) {
        Subject s = new RealSubject();
        //被代理类classloader
        ClassLoader classLoader = s.getClass().getClassLoader();
        //被代理类接口数组
        Class[] interfaces = s.getClass().getInterfaces();
        //handler中传入被代理类实例对象
        InvocationHandler h = new MyInvocationHandler(s);
        //生成代理类，代理类具有被代理类所有方法，传入classLoader,interfaces，以及handler
        Subject s1 = (Subject) Proxy.newProxyInstance(classLoader,interfaces,h);
        //代理类调用被代理类中的方法时，转为调用invocationHander中的invoke方法，如果invocationHandler中不传入被代理类，而是
        //传入代理类，则会循环调用invoke方法，即死循环
        //动态代理的实现，spring aop
        s1.sayHello();

        createProxyClassFile();
    }

    //通过代码跟踪发现在proxy中最终调用proxyGenerator.generateProxyClass()方法生成代理类
    public static void createProxyClassFile(){
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{Subject.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
            out.write(data);}
        catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
