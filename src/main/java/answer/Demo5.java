package answer;

/**
 * @author: ls
 * @date: 2022/3/10
 * @description: try catch finally执行顺序
 */
public class Demo5 {

    /**
     * try catch finally中均有返回时，有无异常均返回finally中
     *
     * @return
     */
    public static int run1() {
        try {
            return 1 / 0;
        } catch (Exception e) {
            System.out.println("异常");
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(run1());
    }
}
