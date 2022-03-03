package algorithm.backtracking;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: 11411
 * @date: 2022/3/3 23:18
 * 在序列中找出符合条件的组合，使用回溯法计算
 * [1,2,3,4]中找出两个数的组合
 */
public class Combination {

    Queue<List<Integer>> results = new Queue<>();
    List<Integer> result = new ArrayList<>();

    /**
     * @param n          待搜索的数组
     * @param k          子数组的长度
     * @param startIndex 当前搜索的位置
     */
    void backtracking(int[] n, int k, int startIndex) {
        if (result.size() == k) {
            results.enqueue(result);
            return;
        }
        for (int i = startIndex; i < n.length; i++) {
            int j = n[i];
            result.add(j);
            backtracking(n, k, ++startIndex);
            result.remove((Object) j);
        }
    }

    public static void main(String[] args) {
        Combination c = new Combination();
        int[] n = {1, 2, 3, 4};
        c.backtracking(n, 2, 0);
        Enumeration<List<Integer>> elements = c.results.elements();
        while (elements.hasMoreElements()) {
            List<Integer> integers = elements.nextElement();
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

}
