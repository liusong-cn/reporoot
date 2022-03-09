package algorithm.backtracking;

/**
 * @author: 11411
 * @date: 2022/3/3 23:16
 * n皇后问题，回溯法解决
 */
public class NQueen {

    public static int N = 8;
    public static int[][] boards = new int[N][N];

    public static int result = 0;

    public static void putQueQue(int k) {
        if (k == N) {
            result++;
            for(int row=0; row<N; row++) {
                for(int col=0; col<N; col++) {
                    System.out.print(boards[row][col] + " ");
                }
                System.out.println();
            }
            System.out.println();
        } else {
            for(int i=0; i<N; i++) {
                if (check(k, i)) {
                    boards[k][i] = 1;
                    putQueQue(k+1);
                    boards[k][i] = 0;
                }
            }
        }
    }

    public static boolean check(int row, int column) {
        for(int i=0; i<row; i++) {
            if (boards[i][column] == 1) {
                return false;
            }
        }

        for(int m=row-1, n=column-1; m>=0 && n >= 0; m--, n--) {
            if (boards[m][n] == 1) {
                return false;
            }
        }

        for(int m=row-1, n=column+1; m>=0 && n<N; m--, n++) {
            if (boards[m][n] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        putQueQue(0);
        System.out.println("result is: " + result);
    }
}
