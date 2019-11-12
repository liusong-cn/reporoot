package com.learning.test.charpter17;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPerformance {

    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();

    static{
        tests.add(new Test<List<Integer>>("add"){
            int test(List<Integer> list, TestParam param){
                int loop = param.loop;
                int size = param.size;
                for (int i = 0; i < loop; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.add(j);
                    }
                }
                return loop*size;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>>{
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        public static void main(String[] args) {
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(Arrays.asList(1,2,3));
            ListTester lt = new ListTester(list,ListPerformance.tests);
            lt.timeTest();
        }
    }


}
