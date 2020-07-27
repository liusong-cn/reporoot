package algorithm.graph;

import algorithm.linked.Stack;

/**
 * @author: ls
 * @date: 2020/7/8 0008 10:51
 * 基于深度优先的顶点排序
 */
public class DepthFirstOrder {

    private boolean[] marked;

    //存放排序后顶点的倒序栈
    private Stack<Integer> stack;

    public void dfs(Digraph g, int v){
        //标记当前顶点已搜索
        marked[v] = true;
        //遍历当前顶点的邻接表
        for (Integer w : g.adj(v)) {
            //如果当前顶点未被搜索，则可以继续递归调用
            if(!marked[w]){
                dfs(g,w);
            }
        }
        //将顶点放入栈中，由于是递归调用，其返回也是从最底层一级一级返回的，因此此处肯定是先将最后一级的顶点入栈
        stack.push(v);
    }

    public Stack<Integer> reversePost(){
        return stack;
    }

    public DepthFirstOrder(Digraph g){
        marked = new boolean[g.V()];
        stack = new Stack<Integer>();
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(2,4);

        DepthFirstOrder d = new DepthFirstOrder(g);
        Stack<Integer> s = d.reversePost();
        while (!s.isEmpty()){
            System.out.println(s.pop() + 1);
        }
    }
}
