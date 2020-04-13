package com.learning.test.charpter20;

import org.springframework.stereotype.Component;

/**
 * @author: ls
 * @date: 2020/4/10 0010 13:36
 */
@Component
public class SimpleBean {
    public String name;

    @XmlStructure
    public void say(){
        System.out.println("111");
    };
}
