package review.classimpl;

/**
 * @author:11411
 * @date: 2020/8/26 9:38
 **/
public class Test {
    public static void main(String[] args) {
        IPeople ch = new Chinese();
        IPeople us = new American();
        //发现实现接口时，声明类型为IPeople时，并不能看到运行时类型类的方法，即不能调用Chinese.do1()
        ch.doSomething();
        Chinese sichuan = new Sichuan();
        //继承父类时,声明类型为父类类型时，同样无法使用子类特有方法，即看不到sichuan.sichuando()
        sichuan.doSomething();
    }
}
