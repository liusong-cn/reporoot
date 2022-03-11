package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ls
 * @date: 2022/3/10
 * @description: 一个箱子最多能装 20kg的重量。
 * 现有物品如下：
 * 物品a 3kg 价值 4元
 * 物品b 4kg 价值 6元
 * 物品c 2kg 价值  3元
 * 物品d 5kg 价值 8元
 * 物品e 8kg 价值 13元
 * 物品f 7kg  价值 12元
 * 物品g 5kg  价值 11元
 * 通过建模能够输出这个箱子能装的物品最大价值方案
 */
public class Combination1 {

    private static final int[] weights = {3, 4, 2, 5, 8, 7, 5};

    private static final int[] prices = {4, 6, 3, 8, 13, 12, 11};

    private static final List<Integer> index = new ArrayList<>();

    private static int threshold = 20;

    public static void backtracking(int i) {
        if (i > weights.length - 1 || getWeight() + weights[i] > threshold) {
            System.out.println(getPrice());
            System.out.println("weight:" + getWeight());
            return;
        }
        for (int j = i; j < weights.length; j++) {
            index.add(j);
            backtracking(j + 1);
            index.remove(index.size() - 1);
        }
    }

    public static int getWeight() {
        return index.stream().mapToInt(i -> weights[i]).sum();
    }

    public static int getPrice() {
        return index.stream().mapToInt(i -> prices[i]).sum();
    }

    public static void main(String[] args) {
        backtracking(0);
    }
}
