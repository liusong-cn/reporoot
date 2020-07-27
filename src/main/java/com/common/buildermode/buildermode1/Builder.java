package com.common.buildermode.buildermode1;

/**
 * @author:11411
 * @date: 2020/7/27 13:30
 **/
public interface Builder {

    Builder buildA();

    Builder buildB();

    Builder buildC();

    Product getProduct();
}
