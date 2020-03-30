package com.learning.test.charpter19;

/**
 * @author: ls
 * @date: 2020/3/30 0030 23:40
 */
public class Test {
    public static void main(String[] args) {
        Person p  = new Person();
        PersonMapping.AGE.handle(p);
        PersonMapping.NAME.handle(p);
        System.out.println(p.getAge() + p.getName());
    }
}
