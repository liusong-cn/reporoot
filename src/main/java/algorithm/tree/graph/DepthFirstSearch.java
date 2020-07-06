package algorithm.tree.graph;

/**
 * @author: ls
 * @date: 2020/7/4 0004 11:45
 * 图的搜索方式
 * 深度优先搜索
 * 此处将每一个顶点从0开始排序
 */
public class DepthFirstSearch {

    //与给定顶点相连的顶点数量
    private int count;
    //顶点是否被搜索过的布尔数组，索引为顶点
    private boolean[] marked;

    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.getV()];
        //这一步似乎多余，实例变量在实例化时会自动赋默认值，int默认为0
        count = 0;
    }

    //找到
    public void dfs(Graph g, int v){
        //将当前顶点标记为已搜索
        marked[v] = true;
        //查找邻接表，对每一个邻接顶点判断是否已被搜索，未被搜索则递归调用
        for (Integer w : g.adj(v)) {
            //未被搜索，则递归
            if(!marked[w]){
                dfs(g,w);
            }
        }
        //相通顶点个数加1
        count++;
    }

    //判断顶点w是否与顶点v相通
    public boolean marked(int w){
        //如果相通，则必然被搜索过
        return marked[w];
    }

    //返回与给定顶点相通顶点的个数
    public int count(){
        return count;
    }
}
