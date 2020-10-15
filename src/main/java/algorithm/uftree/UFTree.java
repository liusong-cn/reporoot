package algorithm.uftree;

import java.security.acl.Group;

/**
 * @author:ls
 * @date: 2020/05/14 11:15
 *并查集优化，并查树
 * 每个元素为索引，索引处的值为该元素的父节点
 * n个元素优化后的union()方法去掉了union内部的循环，将所有元素union，
 * 时间复杂度为o(n);但内部find()在UF中为o(1),在UFTree中最坏为o(n),因此整个union方法最坏
 * 还是为o(n^2)
 **/
public class UFTree {

    private int count;

    private int[] groups;

    public UFTree(int count) {
        groups = new int[count];
        for (int i = 0; i < count; i++) {
            //初始化时元素的父节点为自身
            groups[i] = i;
        }
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public int[] getGroups(){
        return groups;
    }

    //元素是否同组
    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    //查找p元素根节点
    public int find(int p){
        int parent = groups[p];
        //当元素父节点为自身时，表示已找到根节点
        if(parent == p){
            return parent;
        }else{
            //否则递归查找父节点
            p = groups[p];
            parent = find(p);
        }
        return parent;
    }

    //合并元素分组
    public void union(int p, int q){
        //查找根节点
        int pr = find(p);
        int qr = find(q);
        if(pr == qr){
            return;
        }
        //让pr的父节点为qr的父节点，即将pr设为qr的子节点
        groups[pr] = groups[qr];
        count--;
    }

    public static void main(String[] args) {
        UFTree uftree = new UFTree(8);
        System.out.println("初始化时分组个数:" + uftree.getCount());
        uftree.union(4,5);
        System.out.println("合并后分组数:" + uftree.getCount());
        System.out.println("合并后4,5是否同组:" + uftree.connected(4,5));
        System.out.println("合并后元素父节点为");
        for (int i = 0; i < 8; i++) {
            System.out.print(uftree.getGroups()[i]+",");
        }
    }
}
