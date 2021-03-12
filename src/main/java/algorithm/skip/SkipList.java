package algorithm.skip;

import java.util.Random;
import java.util.Stack;

/**
 * @author: ls
 * @date: 2021/3/12 10:39
 * 跳表
 * 跳表通过在有序链表上方增加若干层的索引，从而在查询时避免全表顺序查找，通过索引进行定位后在小范围内顺序查找，
 * 以空间换时间，平均的复杂度为O(n/2)
 **/
//跳表类
public class SkipList<T>{

    SkipNode head;//头节点

    int highLevel;//当前跳表索引成熟

    Random random;//用于投掷硬币

    final int MAX_LEVEL = 32;//最大的层

    public SkipList() {

        Random random = new Random();
        //头节点不存储数据
        head = new SkipNode<>(Integer.MIN_VALUE, null);
        highLevel = 0;//这一步可省略
    }

    //根据key获取节点，找不到则null
    public SkipNode get(int key){
        SkipNode team = head;
        while(team != null){
            if(team.key == key){
                return team;
            }else if(team.right == null){//右侧没有，只能向下
                team = team.down;
            }else if(team.right.key < key){//右侧还有小于比key小的索引节点，那么向右
                team = team.right;
            }else {
                team = team.down;//表明右侧没有合适的节点，那么只能向下
            }

        }
        return null;
    }

    //删除节点，返回该节点
    public SkipNode delete(int key){
        SkipNode team = head;
        SkipNode deleteNode = null;
        while(team != null){
            if(team.right == null){//右侧为空只能向下
                team = team.down;
            }else if(team.right.key == key){//待删除节点在右侧并且找到
                deleteNode = team.right;
                team.right = team.right.right;//更新同一层级链表引用关系
                team = team.down;//继续删除该节点的下层节点
            }else if(team.right.key > key){//右侧节点比当前大，说明只可能在当前节点的下一层
                team = team.down;
            }else {//说明还可以继续向右查找
                team = team.right;
            }
        }
        return deleteNode;
    }

    //
    public void add(SkipNode node){
        int key = node.key;
        SkipNode findNode = get(key);
        //找到已有节点并替换
        if(findNode != null){
            findNode.value = node.value;
            return;
        }

        Stack<SkipNode> stack = new Stack<SkipNode>();//存储向下的节点，这些节点可能在右边插入新节点
        SkipNode team = head;//查找待插入节点，找到最底层的那个节点
        while(team != null){
            //右侧为空只能向下
            if(team.right == null){
                stack.add(team);//将曾经向下的节点记录
                team = team.down;
            }else if(team.right.key > key){//右侧节点比key大，所以应该向下
                stack.add(team);
                team = team.down;
            }else {
                team = team.right;
            }
        }

        int level = 1;//当前层数，从第一层开始添加(第一层必须添加，先添加在判断)
        SkipNode downNode = null;//保持前驱节点
        while (!stack.isEmpty()){
            //在该层插入node
            team = stack.pop();//抛出待出入的左侧节点
            SkipNode nodeTeam = new SkipNode(node.key, node.value);//节点需要重新创建
            nodeTeam.down = downNode;//处理竖方向
            downNode = nodeTeam;//标记新的节点下次使用
            //说明插入在末尾
            if(team.right == null){
                team.right = nodeTeam;
            }
            else {//水平方向处理
                //右侧还有节点，插入在两者之间
                nodeTeam.right = team.right;
                team.right = nodeTeam;
            }
            //考虑是否需要向上
            if(level > MAX_LEVEL){//已经到达最高级节点
                break;
            }
            double num = random.nextDouble();//0-1的随机数
            if(num > 0.5)//运气不好结束
                break;
            level++;
            //比当前最大高度大但是在允许范围内，需要该表head节点
            if(level > highLevel){
                highLevel = level;
                //需要创建一个新的节点
                SkipNode highHeadNode = new SkipNode(Integer.MIN_VALUE, null);
                highHeadNode.down = head;
                head = highHeadNode;//改变head
                stack.add(head);//下次抛出head
            }
        }

    }

}


//跳表节点类
class SkipNode<T> {

    int key;

    T value;

    SkipNode right, down;

    SkipNode(int key, T value) {
        this.key = key;
        this.value = value;
    }
}
