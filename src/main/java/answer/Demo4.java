package answer;

/**
 * @author: ls
 * @date: 2022/3/8
 * @description:
 */
public class Demo4 {

    public static void main(String[] args) {
        byte b1 = 2, b2 = 3, b3, b4;
        final byte b5 = 1, b6 = 2;
        // b5,b6被final强制固定类型，编译期常量
        b3 = b5 + b6;
        // 字面量 1  3虽然时int类型，但被优化
        byte b7 = 1 + 3;
        // byte short 等少于4字节的在进行计算时自动提升为int类型，需强制转换才行
        b4 = (byte) (b1 + b2);

    }
}
