package algorithm.tree.graph;

import algorithm.linked.Queue;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author: ls
 * @date: 2020/7/4 0004 11:09
 * 图的入门
 * 图有顶点和链接顶点的边构成
 * 度：连接顶点的边的数量
 * 图顶点的关系的表示可以用邻接表和邻接矩阵
 * 邻接矩阵的复杂度为顶点的平方，通常不用
 * 邻接表的复杂度小于o(n^2)
 */
public class Graph {

    //顶点数量vertex
    private final int V;

    //边的数量edge
    private int E;

    //每个顶点的邻接表 adjacency list
    private Queue<Integer>[] adj;

    public Graph(int v) {
        V = v;
        this.E = 0;
        adj = new Queue[v];
        //初始化邻接表数组
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    //通过顶点添加边的数量，针对无向图
    public void addEdge(int i, int j){
        //i的邻接表数量加1
        adj[i].enQueue(j);
        //j的邻接表数量加1
        adj[j].enQueue(i);
        //无向图中，边加1
        E++;
    }

    //获取i顶点的邻接表
    public Queue<Integer> adj(int i){
        return adj[i];
    }

}
