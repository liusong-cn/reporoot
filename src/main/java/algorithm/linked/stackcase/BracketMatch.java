package algorithm.linked.stackcase;

import algorithm.linked.Stack;

/**
 * @author: ls
 * @date: 2021/1/25 16:27
 * 判断括号是否成对匹配
 * 1.循环整个待匹配字符串
 * 2.左括号一直压栈
 * 3.右括号时则从栈中取出左括号，若为空则说明不匹配
 * 4.循环结束时判断栈是否为空，不为空则不匹配
 **/
public class BracketMatch {

    public static boolean isMatch(){
        Stack<String> brackets =  new Stack<>();
        String s = "(成都(双流(东升))))";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                brackets.push(String.valueOf(s.charAt(i)));
            }else if(s.charAt(i) == ')'){
                String rightBracket = brackets.pop();
                if(rightBracket == null)
                    return false;
            }
        }

        if(brackets.size() > 0)
            return false;
        else
            return true;

    }

    public static void main(String[] args) {
        System.out.println(isMatch());
    }
}
