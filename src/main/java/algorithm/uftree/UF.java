package algorithm.uftree;

/**
 * @author:ls
 * @date: 2020/05/14 11:19
 * 并查集
 * 一种树形结构
 * 1.每个元素都是树中唯一的一个节点
 * 2.一组中的元素都在同一颗树中
 * 3.不同组的元素各自没有关系
 * 4.元素在树中父子关系没有要求
 * 由于n个元素合并需要n-1次union(),且每次union循环整个列表，因此时间复杂度为o(n^2)
 **/
public class UF {

    //分组个数
    private int count;

    //元素及其所在分组标识,索引为元素,元素为分组标识
    private int[] groups;

    public UF(int count) {
        //初始化分组
        groups = new int[count];
        //初始化时，分组的每个元素对应的分组标识为索引
        for (int i = 0; i < count; i++) {
            groups[i] = i;
        }
        //初始化分组个数
        this.count = count;
    }

    //查询分组个数
    public int getCount(){
        return count;
    }

    //判断是否同一分组
    public boolean connected(int p, int q){
        //通过元素所在分组标识判断
        return groups[p] == groups[q];
    }

    //合并元素所在分组
    public void union(int p, int q){
        //在同一分组不合并
       if(connected(p,q))
           return;
       //将p所在分组的元素的分组改为q所在分组
        int pg = findGroup(p);
        int qg = findGroup(q);
        for (int i = 0; i < groups.length; i++) {
            //查询p同组元素
            if(groups[i] == pg){
                //将其分组设为q所在分组
                groups[i] = qg;
            }
        }
        //分组数减一
        count--;
    }

    //查询元素所在分组
    public int findGroup(int q){
        return groups[q];
    }

    public int[] getGroups() {
        return groups;
    }

    public static void main(String[] args) {
        UF uf = new UF(8);
        //合并前分组数
        System.out.println("合并前分组数:" + uf.getCount());
        //合并一次
        uf.union(3,5);
        System.out.println("合并后分组数:" + uf.getCount());
        System.out.println("合并后每个元素的分组标识");
        for (int i = 0; i < 8; i++) {
            System.out.print(uf.getGroups()[i] + ",");
        }
    }
}
