package com.learning.test.charpter20;

import org.springframework.stereotype.Component;

/**
 * 给此类使用注解
 */
@DBTable(name="member")
@Component
public class Member {
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


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public void doSomething(){
        System.out.println("do something");
    }

    @Override
    public String toString() {
        return handle;
    }

    public static void main(String[] args) {
        new Member().getAge();
    }
}
