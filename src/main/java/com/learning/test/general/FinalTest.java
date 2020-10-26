package com.learning.test.general;

/**
 * @author:ls
 * @date: 2020/10/26 13:11
 * 测试final修饰field情况
 **/
public class FinalTest {

    public static void main(String[] args) {
        //final修饰变量表示不可变的，即初始化后不能再行更改引用
        //但并不意味着不能对变量的值内部做修改，因此可以看到对array[0]重新赋值并未引发异常
        final int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[0] = 2;
        System.out.println(array[0]);
        final int[] array1 = {2,3,5};
        int a0 = array1[0];
        //由于final修饰后不能更改引用，因此此处报错
//        array = array1 ;

        final String a = "abc";
        //此处对a重新赋值就会导致异常
//        a = "bcd";
    }
}
