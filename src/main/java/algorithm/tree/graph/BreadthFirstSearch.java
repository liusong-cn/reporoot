package algorithm.tree.graph;

import algorithm.linked.Queue;

/**
 * @author: ls
 * @date: 2020/7/6 0006 11:09
 * 广度优先搜索
 * 优先搜索兄弟节点，通过辅助队列，运用树结构的层序遍历思想
 */
public class BreadthFirstSearch {

    //相通的顶点个数
    private int count;

    //判断顶点是否被搜索过
    private boolean[] marked;

    private Queue<Integer> queue;

    public void bfs(Graph g, int v){
        //将顶点放入队列
        queue.enQueue(v);
        //标记该顶点为搜索过
        marked[v] = true;
        //当队列不为空，取出一个顶点后，对该顶点的邻接表递归调用
        while (!queue.isEmpty()){
            Integer w = queue.dequeue();
            for (Integer i : g.adj(w)) {
                if(!marked[i]){
                    bfs(g,i);
                }
            }
        }
        //相通顶点个数加1
        count++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
