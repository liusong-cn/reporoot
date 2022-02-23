package algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ls
 * @date: 2022/2/15
 * @description: 冒泡排序
 */
public class Bubble {

    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int greater = greater(a, j, i);
                if (greater > 0) {
                    exchange(a, i, j);
                }
            }
        }
    }

    public static int greater(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]);
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1,3,5,8,2,6,7};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
