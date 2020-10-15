package algorithm.uftree;

/**
 * @author:ls
 * @date: 2020/05/14 16:09
 * 并查树优化
 * 在UFTree中union时将一个元素的根节点的根节点直接设为另一个元素的根节点，
 * 这种方式在最坏情况下会导致树的高度和数组的长度相同，影响find()的效率
 * 因此通过在union时将小树挂载大树上，减小树的高度，提高find效率
 **/
public class UFTreeWeighted {

    //分组数
    private int count;

    //节点所在的根节点数据，索引为节点，值为根节点
    private int[] groups;

    //每个根节点所在树的节点个数
    private int[] size;

    public int getCount() {
        return count;
    }

    public int[] getGroups() {
        return groups;
    }

    public UFTreeWeighted(int count) {
        this.count = count;
        groups = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            //初始化时每个节点的根节点都是自身
            groups[i] = i;
            //初始化时每个节点所在树的节点个数都是1
            size[i] = 1;
        }
    }

    //判断是否同组
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    //查找元素根节点
    public int find(int p){
        while (true){
            if(groups[p] == p){
                return p;
            }
            //将元素设为其父节点，继续查找根节点
            p = groups[p];
        }
    }

    //合并节点的分组
    public void union(int q, int p){
        //同一分组无需合并
        if(connected(q,p)){
            return;
        }
        //查找根节点
        int qroot = find(q);
        int proot = find(p);
        //比较根节点所在树大小
        if(size[qroot] < size[proot]){
            //将小树的根节点的父节点设为大树的根节点
            groups[qroot] = proot;
            //大树的节点个数合并小树
            size[proot]+=size[qroot];
        }else {
            groups[proot]=qroot;
            size[qroot]+=size[proot];
        }
        //分组数减1
        count--;

    }
}
