package com.common.threadcommunication.visibility;

/**
 * 一个不可变对象
 * @author:ls
 * @date: 2020/9/28 10:33
 **/
public  final class ImmutableObject {
    private final int age;

    public ImmutableObject(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}
