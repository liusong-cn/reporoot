package algorithm;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2022/2/23
 * @description: 插入排序
 * 原理类似扑克牌排序
 */
public class Insertion {

    public static void sort(Comparable[] origin) {
        for (int i = 1; i < origin.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!greater(origin, j, j - 1)) {
                    exchange(origin, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static boolean greater(Comparable[] origin, int i, int j) {
        return origin[i].compareTo(origin[j]) > 0;
    }

    public static void exchange(Comparable[] origin, int i, int j) {
        Comparable temp = origin[i];
        origin[i] = origin[j];
        origin[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 5, 1, 3, 7, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
