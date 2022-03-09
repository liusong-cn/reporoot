package answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ls
 * @date: 2022/3/4
 * @description: 8皇后问题，采用回溯法解决
 */
public class NQueen {

    List<int[][]> a = new ArrayList<>();

    int[][] s = new int[8][8];

    int result;

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.backtracking(0);
        System.out.println(nQueen.result);
    }

    /**
     * @param row
     * 回溯法核心3步：
     * 1.判断出口,并收集结果
     * 2.循环
     * 3.循环中试探结果（先放再回收）并递归到下一层
     */
    public void backtracking(int row) {
        if (row > 7) {
            result++;
            // s = new int[8][8];
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (check(row, i)) {
                s[row][i] = 1;
                backtracking(row + 1);
                s[row][i] = 0;
            }
        }


    }

    /**
     * 皇后位置检查
     *
     * @param row
     * @param column
     * @return
     */
    public boolean check(int row, int column) {
        // 检查行列
        for (int i = 0; i < row; i++) {
            if (s[i][column] == 1) {
                return false;
            }
        }
        // 检查主对角线
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (s[i][j] == 1) {
                return false;
            }
        }
        // 检查负对角线
        for (int i = row - 1, j = column + 1; i >= 0 && j < 8; i--, j++) {
            if (s[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
