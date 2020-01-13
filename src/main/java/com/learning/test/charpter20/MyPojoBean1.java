package com.learning.test.charpter20;

import org.springframework.stereotype.Component;

/**
 * 给此类使用注解
 */
@DBTable(name="member")
@Component
public class MyPojoBean1 {
    //由于在@SQLString中，含有value元素，且此处只给value赋值，那么可以不必使用名值对，直接赋值
    @SQLString(30)
    String firstName;

    @SQLString(20)
    String lastName;

    @SQLInteger
    Integer age = 1;

    @SQLString(value=30,constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    @Override
    public String toString() {
        System.out.println("MyPojoBean1:{'age':" + age + "}");
        return super.toString();
    }

    @Logger
    public void sayAge(){
        System.out.println("age:" + age);
    }

    public void speakSomething(){
        System.out.println("should i speak");
    }
}

