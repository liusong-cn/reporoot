package com.learning.test.charpter20;

public class PasswordUtil {

    @TestAnnotation(id=1,description = "密码加密")
    public void encryptPassword(){
        System.out.println("模拟加密");
    }

    //由于description有默认值，此处使用了默认值
    @TestAnnotation(id=2)
    public void descryptPassword(){
        System.out.println("模拟解密");
    }

}
