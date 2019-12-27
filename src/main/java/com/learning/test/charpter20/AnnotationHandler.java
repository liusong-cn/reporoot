package com.learning.test.charpter20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnotationHandler {
    //通过目标类找到目标类上的注解，对注解进行处理
    public static void traceTestAnnotation(List<Integer> ids, Class<?> clazz){
        for (Method m : clazz.getDeclaredMethods()) {
            TestAnnotation an = m.getAnnotation(TestAnnotation.class);
            //假设对注解的处理
            System.out.println(an.description());
            ids.remove(an.id());
        }
    }

    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<Integer>();
        Collections.addAll(ids,1,2,3,4);
        traceTestAnnotation(ids,PasswordUtil.class);
        System.out.println(ids.toString());
    }
}
