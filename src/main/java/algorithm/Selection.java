package algorithm;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2022/2/23
 * @description: 选择排序
 * 1.假定每轮排序时首个最小，依次比较后续的，若后者较小，则交换索引，则一轮后首个最小
 * 2.首个索引加1，重复每轮排序
 */
public class Selection {

    public static void sort(Comparable[] origin) {
        for (int i = 0; i < origin.length - 1; i++) {
            for (int j = i + 1; j < origin.length; j++) {
                if (greater(origin, i, j)) {
                    exchange(origin, i, j);
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
        Integer[] a = {1, 5, 3, 7, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
