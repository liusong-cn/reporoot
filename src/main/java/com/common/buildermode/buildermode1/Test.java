package com.common.buildermode.buildermode1;

/**
 * @author:11411
 * @date: 2020/7/27 13:37
 **/
public class Test {

    public static void main(String[] args) {
        Builder b = new ConcreteBuilder(new Product());
        //通过这种连缀的方式可以省略中间的指挥者director,让具体的建造者自行决定如何组装产品
        Product p = b.buildA().buildB().buildC().getProduct();
        p.toString();
    }
}
