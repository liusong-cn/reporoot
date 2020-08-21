package com.annotation;

import java.lang.annotation.*;

/**
 * @author:11411
 * @date: 2020/8/21 17:01
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";
}
