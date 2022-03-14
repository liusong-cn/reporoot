package algorithm.graph;

/**
 * @author: ls
 * @date: 2020/7/8 0008 09:10
 * 检测是否存在有向环
 * 存在有向环则必定不能使用拓扑排序
 */
public class DirectedCycle {

    //顶点是否被搜索数组
    private boolean[] marked;
    //顶点是否在栈中数组
    private boolean[] onStack;

    //是否有环
    private boolean hasCycle;

    public DirectedCycle(Digraph g){
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        //对每一个顶点调用深度优先算法，判断是否有环
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i])
                dfs(g,i);
        }

    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public void dfs(Digraph g,int v){
        //标记已被搜索
        marked[v] = true;
        //标记栈中已有
        onStack[v] = true;
        //遍历邻接表，
        for (Integer integer : g.adj(v)) {
            //判断当前顶点是否被搜索过，未则递归调用dfs
            if(!marked[integer]){
                dfs(g,integer);
            }

            //判断当前顶点是否在栈中，是则表示有环
            if (onStack[integer]) {
                hasCycle = true;
                return;
            }
        }
        //从栈中出栈
        onStack[v] = false;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,0);
        DirectedCycle d = new DirectedCycle(g);
        System.out.println(d.hasCycle());
    }


}
