package com.common.lambda;

/**
 * @author:ls
 * @date: 2020/9/15 17:01
 **/
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        int add = test.operate((a,b)->a+b, 2,3);
        int minus = test.operate((c,d)->c-d, 5,2 );
        int dive = test.operate((c,d)->c/d,6,3);
    }

    //传入接口和实参，调用函数式接口的方法
    //需满足参数中含有函数式接口，方法体中调用接口的唯一方法即可
    public int operate(MathOperation m, int a ,int b){
        return m.operation(a, b);
    }
}
