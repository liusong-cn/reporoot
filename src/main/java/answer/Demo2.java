package answer;

/**
 * @author: ls
 * @date: 2022/3/3
 * @description:
 */
public class Demo2 {

    /**
     * final修饰的字段可以在构造里初始化
     * 或者初始化块里
     */
    private final int a;

    {
        a = 3;
    }

    // public Demo2(int a) {
    //     this.a = a;
    // }
}
