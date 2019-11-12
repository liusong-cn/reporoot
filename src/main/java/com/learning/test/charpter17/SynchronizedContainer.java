package com.learning.test.charpter17;

import java.util.*;

public class SynchronizedContainer {

    public static void main(String[] args) {
        //这是创建同步容器的方法
        Collection<Integer> c = Collections.synchronizedCollection(new ArrayList<Integer>());
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String,String>());
    }
}
