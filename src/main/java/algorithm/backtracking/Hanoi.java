package algorithm.backtracking;

/**
 * @author: 11411
 * @date: 2022/3/14 23:23
 * 汉诺塔问题源自印度一个古老的传说，印度教的“创造之神”梵天创造世界时做了 3 根金刚石柱，
 * 其中的一根柱子上按照从小到大的顺序摞着 64 个黄金圆盘。
 * 梵天命令一个叫婆罗门的门徒将所有的圆盘移动到另一个柱子上，
 * 移动过程中必须遵守以下规则：
 * 每次只能移动柱子最顶端的一个圆盘；
 * 每个柱子上，小圆盘永远要位于大圆盘之上；
 */
public class Hanoi {

    //
    public int i = 0;

    public  void hanoi(int num, char source, char target, char support){
        if(num == 1){
            i++;
            System.out.println(i + ": 把" + source + "移动到" + target);
            return;
        }else {
            hanoi(num-1, source, support,target);
            System.out.println(++i + ": 把" + source + "移动到" + target);
            hanoi(num-1,support,target,source);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3,'A','C', 'B');
    }
}
