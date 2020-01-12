package com.learning.test.charpter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 练习注解的定义
 * 定义该注解目的在于抽取target上的公共方法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {

    //注解也是java类，也可以用访问限制符来限定访问 public protected private
    public String value() default "";
}
