package algorithm.stack_prac;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: ls
 * @date: 2022/1/17
 * @description:
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        Condition<Integer> a = new Condition<>(2,0,1,1);
        Condition<Integer> b = new Condition<>(2,0,1,2);
        Condition oper1 = new Condition(1,2,1,null);
        Condition<Integer> c= new Condition<>(2,0,2,3);
        Condition<Integer> d = new Condition<>(2,0,2,6);
        Condition oper2 = new Condition(1,2,2,null);
        Condition oper3 = new Condition(1,2,2,null);
        List<Condition<Integer>> conditions = new ArrayList<>();
        conditions.add(a);
        conditions.add(b);
        conditions.add(oper1);
        conditions.add(c);
        conditions.add(d);
        conditions.add(oper2);
        conditions.add(oper3);
        Stack<Condition<Integer>> stack = new Stack<>();
        for (Condition condition : conditions) {
            if(condition.getType() == 2){
                stack.push(condition);
            }else {
                int size = condition.getSize();
                List<Condition<Integer>> groups = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    groups.add(stack.pop());
                }
                int operator = condition.getOperator();
                switch (operator){
                    case 1:
                        int result = 0;
                        for (Condition group : groups) {
                            if(group.getData() instanceof Integer){
                                result += (Integer) group.getData();
                            }
                        }
                        Condition<Integer> con = new Condition<>(2,0,1,result);
                        stack.push(con);
                        break;
                    case 2:
                        int res = 0;
                        for (Condition<Integer> group : groups) {
                            res -= group.getData();
                        }
                        Condition<Integer> con1 = new Condition<>(2,0,1,res);
                        stack.push(con1);
                        break;
                    default:
                        throw new Exception("不支持的操作类型");
                }

            }
        }
        Condition<Integer> pop = stack.pop();
        System.out.println(pop.getData());

    }
}
