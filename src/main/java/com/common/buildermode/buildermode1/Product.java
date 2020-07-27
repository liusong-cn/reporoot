package com.common.buildermode.buildermode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:11411
 * @date: 2020/7/27 13:31
 **/
public class Product {

    private List<String> parts = new ArrayList<>();

    public void addPart(String mes){
        parts.add(mes);
    }

    @Override
    public String toString() {
        return "Product{" +
                "parts=" + parts +
                '}';
    }
}
