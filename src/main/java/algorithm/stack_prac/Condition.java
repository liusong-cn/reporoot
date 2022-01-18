package algorithm.stack_prac;

/**
 * @auther: ls
 * @date: 2022/1/17
 * @description: 模拟生成condition，实现类似多叉语法树
 */
public class Condition<T> {

    /**
     * 1-operator 2-operand
     */
    private int type;

    private int size;

    /**
     * 1-union 2-intersection 3-exlude
     */
    private int operator;

    private T data;

    public Condition(int type, int size, int operator, T data) {
        this.type = type;
        this.size = size;
        this.operator = operator;
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getOperator() {
        return operator;
    }

    public T getData() {
        return data;
    }
}
