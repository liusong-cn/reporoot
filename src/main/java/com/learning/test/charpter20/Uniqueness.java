package com.learning.test.charpter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Uniqueness {
    //嵌套注解时如果没有指定嵌套的注解默认值，那么就会按照注解本身的默认值走，如需要，那么按照下方所示重新指定注解默认值
    Constraints constraints() default @Constraints(unique = true);
}
