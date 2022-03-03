package answer;

/**
 * @author: ls
 * @date: 2022/3/2
 * @description:
 */
public class Demo1 {


    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int k = 0;
        for (int i = 0; i < 5; i++) {
            if (++x > 2 && ++y > 2 && k++ > 2) {
                x++;
                System.out.println(x);
                ++y;
                k++;
            }
        }
        System.out.println("x=" + x + ",y=" + y + ",k=" + k);
    }
}
