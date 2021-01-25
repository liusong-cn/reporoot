package algorithm.linked.stackcase;

import algorithm.linked.Stack;

/**
 * @author: ls
 * @date: 2020/6/19 0019 10:28
 * 逆波兰表达式(后缀表达式)：运算符总是放在相关操作数之后 eg: bc-d+a*
 * 中缀表达式:每一个运算符左右两侧各有一个操作数 eg:a*(d+(b-c))
 */
public class ReversePollan {

    public static void main(String[] args) {
        //中缀表达式 ((3+4)*5-1)/2的逆波兰表达式
        //  3 4 + 5 * 1 - 2 /
        String[] notation = {"3","4","+","5","*","1","-","2","/"};
        System.out.println(caculate(notation));

    }

    public static int caculate(String[] notation){
        //1.定义一个栈，用来存储操作数
        Stack<String> stack = new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个元素
        for (String s : notation) {
            Integer o1;
            Integer o2;
            //3.判断当前元素是运算符还是操作数
            switch (s){
                case "+":
                    o1 = Integer.valueOf(stack.pop());
                    o2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(o1+o2));
                    break;
                case "-":
                    o1 = Integer.valueOf(stack.pop());
                    o2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(o2-o1));
                    break;
                case "*":
                    o1 = Integer.valueOf(stack.pop());
                    o2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(o1*o2));
                    break;
                case "/":
                    o1 = Integer.valueOf(stack.pop());
                    o2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(o2/o1));
                    break;
                default:
                    //4.是操作数则压入栈中，否则从栈中取出两个操作数进行运算
                    stack.push(s);
                    break;
            }
        }

        return Integer.valueOf(stack.pop());
    }



}
