package com.learning.test.charpter19;

public enum EnumTest {

    //预先定义enum实例,使用带参构造器，如果想要增加自定义的方法时，一定要在最后一个实例后加；
    YESTERDAY("gone"),TODAY("hold"),TOMARROW("EXPECT");

    //enum除了类实例预先定义好，其他方面和普通类一致,可以拥有方法和属性，甚至可以拥有main方法
    private String description;

    public String getDescription(){
        return description;
    }
    //由于enum只能在内部创建实例，因此作用于修饰符public等不生效
    EnumTest(String s){
        description = s;
    }

    public static void main(String[] args) {
        for (EnumTest e : EnumTest.values()) {
            //每个enum实例都有name方法用来返回实例名称，实例也可以拥有普通方法
            //设想可以通过enum实现java中常用的常量定义，且实现类似的key-value对也是ok的5
            System.out.println(e.name() + ":" + e.getDescription());
        }
    }


}
